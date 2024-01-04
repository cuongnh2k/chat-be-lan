package website.chatx.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import website.chatx.core.common.CommonAuthContext;
import website.chatx.core.common.CommonListResponse;
import website.chatx.dto.res.ChannelRes;
import website.chatx.entities.ChannelEntity;
import website.chatx.entities.UserEntity;
import website.chatx.enums.ChannelTypeEnum;
import website.chatx.mapper.ChannelMapper;
import website.chatx.mapper.MessageMapper;
import website.chatx.repositories.ChannelRepository;
import website.chatx.repositories.MessageRepository;
import website.chatx.service.ChannelService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository channelRepository;
    private final MessageRepository messageRepository;

    private final CommonAuthContext commonAuthContext;

    private final ChannelMapper channelMapper;
    private final MessageMapper messageMapper;

    @Override
    public CommonListResponse<ChannelRes> search(ChannelTypeEnum type, String name, Pageable pageable) {
        Page<ChannelEntity> channelEntityPage;
        if (StringUtils.hasText(name)) {
            channelEntityPage = channelRepository.findByTypeAndNameContaining(type, name, pageable);
        } else {
            channelEntityPage = channelRepository.findByType(type, pageable);
        }
        List<ChannelEntity> channelEntities = channelEntityPage.getContent();
        if (type == ChannelTypeEnum.FRIEND) {
            channelEntities.forEach(o -> o.getUserChannels().forEach(oo -> {
                UserEntity userEntity = oo.getUser();
                if (!userEntity.getId().equals(commonAuthContext.getUserEntity().getId())) {
                    o.setAvatarUrl(userEntity.getAvatarUrl());
                    o.setName(userEntity.getName());
                }
            }));
        }
        return CommonListResponse.<ChannelRes>builder()
                .content(channelEntities.stream()
                        .map(o -> {
                            ChannelRes channelRes = channelMapper.toChannelRes(o);
                            channelRes.setMessages(Collections.singletonList(
                                    messageMapper.toMessageRes(messageRepository.findFirstByChannelOrderByCreatedAtDesc(o))
                            ));
                            return channelRes;
                        })
                        .collect(Collectors.toList()))
                .page(pageable.getPageNumber())
                .size(pageable.getPageSize())
                .totalPages(channelEntityPage.getTotalPages())
                .totalElements(channelEntityPage.getTotalElements())
                .build();
    }
}
