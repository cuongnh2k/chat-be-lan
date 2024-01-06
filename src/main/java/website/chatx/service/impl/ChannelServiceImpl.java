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
import website.chatx.core.exception.BusinessLogicException;
import website.chatx.dto.prt.channel.GetDetailChannelPrt;
import website.chatx.dto.prt.channel.GetListChannelPrt;
import website.chatx.dto.res.channel.DetailChannelRes;
import website.chatx.dto.res.channel.list.CurrentMessageRes;
import website.chatx.dto.res.channel.list.ListChannelRes;
import website.chatx.dto.res.channel.list.SenderRes;
import website.chatx.dto.rss.channel.DetailChannelRss;
import website.chatx.dto.rss.channel.ListChannelRss;
import website.chatx.repositories.mybatis.ChannelMybatisRepository;
import website.chatx.service.ChannelService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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
    public CommonListResponse<ListChannelRes> getListChannel(ChannelTypeEnum type, String name, Integer page, Integer size) {
        Long countListChannel;
        if (type == null) {
            countListChannel = channelMybatisRepository.countListChannel(GetListChannelPrt.builder()
                    .userId(commonAuthContext.getUserEntity().getId())
                    .build());
        } else if (type == ChannelTypeEnum.FRIEND) {
            countListChannel = channelMybatisRepository.countListFriend(GetListChannelPrt.builder()
                    .userId(commonAuthContext.getUserEntity().getId())
                    .name(name)
                    .build());
        } else {
            countListChannel = channelMybatisRepository.countListGroup(GetListChannelPrt.builder()
                    .userId(commonAuthContext.getUserEntity().getId())
                    .name(name)
                    .build());
        }
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
        List<ListChannelRss> listChannelRss;
        if (type == null) {
            listChannelRss = channelMybatisRepository.getListChannel(GetListChannelPrt.builder()
                    .userId(commonAuthContext.getUserEntity().getId())
                    .name(name)
                    .offset(commonPaginator.getOffset())
                    .limit(commonPaginator.getLimit())
                    .build());
        } else if (type == ChannelTypeEnum.FRIEND) {
            listChannelRss = channelMybatisRepository.getListFriend(GetListChannelPrt.builder()
                    .userId(commonAuthContext.getUserEntity().getId())
                    .name(name)
                    .offset(commonPaginator.getOffset())
                    .limit(commonPaginator.getLimit())
                    .build());
        } else {
            listChannelRss = channelMybatisRepository.getListGroup(GetListChannelPrt.builder()
                    .userId(commonAuthContext.getUserEntity().getId())
                    .name(name)
                    .offset(commonPaginator.getOffset())
                    .limit(commonPaginator.getLimit())
                    .build());
        }
        return CommonListResponse.<ListChannelRes>builder()
                .content(listChannelRss.stream()
                        .map(o -> ListChannelRes.builder()
                                .id(o.getId())
                                .name(o.getType() == ChannelTypeEnum.FRIEND ? o.getFriendName() : o.getName())
                                .avatarUrl(o.getType() == ChannelTypeEnum.FRIEND ? o.getFriendAvatarUrl() : o.getAvatarUrl())
                                .type(o.getType())
                                .createdAt(Timestamp.valueOf(o.getCreatedAt()).getTime())
                                .updatedAt(Timestamp.valueOf(o.getUpdatedAt()).getTime())
                                .currentMessage(o.getCurrentMessageId() != null
                                        ? CurrentMessageRes.builder()
                                        .id(o.getCurrentMessageId())
                                        .content(o.getCurrentMessageContent())
                                        .createdAt(Timestamp.valueOf(o.getCurrentMessageCreatedAt()).getTime())
                                        .updatedAt(Timestamp.valueOf(o.getCurrentMessageUpdatedAt()).getTime())
                                        .sender(SenderRes.builder()
                                                .id(o.getSenderCurrentMessageId())
                                                .email(o.getSenderCurrentMessageEmail())
                                                .name(o.getSenderCurrentMessageName())
                                                .avatarUrl(o.getSenderCurrentMessageAvatarUrl())
                                                .build())
                                        .build()
                                        : null
                                )
                                .build())
                        .collect(Collectors.toList()))
                .page(page)
                .size(size)
                .totalPages(commonPaginator.getTotalPages())
                .totalElements(countListChannel)
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public DetailChannelRes getDetailChannel(String channelId) {
        DetailChannelRss detailChannelRss = channelMybatisRepository.getDetailChannel(GetDetailChannelPrt.builder()
                .channelId(channelId)
                .userId(commonAuthContext.getUserEntity().getId())
                .build());
        if (detailChannelRss == null) {
            throw new BusinessLogicException(-11);
        }
        return DetailChannelRes.builder()
                .id(detailChannelRss.getId())
                .ownerId(detailChannelRss.getOwnerId())
                .name(detailChannelRss.getType() == ChannelTypeEnum.FRIEND ? detailChannelRss.getFriendName() : detailChannelRss.getName())
                .avatarUrl(detailChannelRss.getType() == ChannelTypeEnum.FRIEND ? detailChannelRss.getFriendAvatarUrl() : detailChannelRss.getAvatarUrl())
                .type(detailChannelRss.getType())
                .createdAt(Timestamp.valueOf(detailChannelRss.getCreatedAt()).getTime())
                .updatedAt(Timestamp.valueOf(detailChannelRss.getUpdatedAt()).getTime())
                .build();
    }
}
