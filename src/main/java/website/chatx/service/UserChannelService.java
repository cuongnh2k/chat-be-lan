package website.chatx.service;

import website.chatx.core.common.CommonListResponse;
import website.chatx.dto.res.userchannel.list.ListMemberRes;

public interface UserChannelService {

    CommonListResponse<ListMemberRes> getListMember(String channelId, String name, Integer page, Integer size);
}
