package website.chatx.service;

import website.chatx.core.common.CommonListResponse;
import website.chatx.core.enums.UserChannelStatusEnum;
import website.chatx.dto.req.channel.AddUserFriendReq;
import website.chatx.dto.req.channel.AddUserGroupReq;
import website.chatx.dto.res.userchannel.list.ListMemberRes;

public interface UserChannelService {

    CommonListResponse<ListMemberRes> getListMember(String channelId, String search, UserChannelStatusEnum status, Integer page, Integer size);

    void addUserFriend(AddUserFriendReq req);

    void addUserGroup(String channelId, AddUserGroupReq req);
}
