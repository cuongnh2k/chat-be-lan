package website.chatx.service;

import website.chatx.core.common.CommonListResponse;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.dto.res.channel.DetailChannelRes;
import website.chatx.dto.res.channel.list.ListChannelRes;

public interface ChannelService {

    CommonListResponse<ListChannelRes> getListChannel(ChannelTypeEnum type, String search, Integer page, Integer size);

    DetailChannelRes getDetailChannel(String channelId);
}
