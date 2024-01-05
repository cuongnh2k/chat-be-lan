package website.chatx.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.chatx.core.common.CommonAuthContext;
import website.chatx.core.common.CommonListResponse;
import website.chatx.core.common.CommonPaginator;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.dto.prt.channel.GetListChannelPrt;
import website.chatx.dto.res.channel.CurrentMessageRes;
import website.chatx.dto.res.channel.ListChannelRes;
import website.chatx.dto.res.channel.SenderRes;
import website.chatx.repositories.mybatis.ChannelMybatisRepository;
import website.chatx.service.ChannelService;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelMybatisRepository channelMybatisRepository;

    private final CommonAuthContext commonAuthContext;

    private final Log LOGGER = LogFactory.getLog(getClass());

    @Override
    @Transactional(readOnly = true)
    public CommonListResponse<ListChannelRes> search(ChannelTypeEnum type, String name, Integer page, Integer size) {
        if (type == null) {
            Integer countListChannel = channelMybatisRepository.countListChannel(GetListChannelPrt.builder()
                    .userId(commonAuthContext.getUserEntity().getId())
                    .build());
            if (countListChannel == 0) {
                return CommonListResponse.<ListChannelRes>builder()
                        .content(new ArrayList<>())
                        .page(page)
                        .size(size)
                        .totalPages(0)
                        .totalElements(0L)
                        .build();
            }
            CommonPaginator commonPaginator = new CommonPaginator(page, size, countListChannel);
            return CommonListResponse.<ListChannelRes>builder()
                    .content(channelMybatisRepository.getListChannel(GetListChannelPrt.builder()
                                    .userId(commonAuthContext.getUserEntity().getId())
                                    .offset(commonPaginator.getOffset())
                                    .limit(commonPaginator.getLimit())
                                    .build()).stream()
                            .map(o -> ListChannelRes.builder()
                                    .id(o.getId())
                                    .name(o.getType() == ChannelTypeEnum.FRIEND ? o.getFriendName() : o.getName())
                                    .avatarUrl(o.getType() == ChannelTypeEnum.FRIEND ? o.getFriendAvatarUrl() : o.getAvatarUrl())
                                    .type(o.getType())
                                    .currentMessage(CurrentMessageRes.builder()
                                            .id(o.getCurrentMessageId())
                                            .content(o.getCurrentMessageContent())
                                            .sender(SenderRes.builder()
                                                    .id(o.getSenderCurrentMessageId())
                                                    .email(o.getSenderCurrentMessageEmail())
                                                    .name(o.getSenderCurrentMessageName())
                                                    .avatarUrl(o.getSenderCurrentMessageAvatarUrl())
                                                    .build())
                                            .build())
                                    .build())
                            .collect(Collectors.toList()))
                    .page(page)
                    .size(size)
                    .totalPages(commonPaginator.getTotalPages())
                    .totalElements(commonPaginator.getTotalItems())
                    .build();
        }
        return null;
    }
}
