package website.chatx.service;

import website.chatx.core.common.CommonListResponse;
import website.chatx.core.enums.UserChannelStatusEnum;
import website.chatx.dto.req.channel.AddUserFriendReq;
import website.chatx.dto.req.channel.AddUserGroupReq;
import website.chatx.dto.req.channel.ReactUserFriendReq;
import website.chatx.dto.req.channel.ReactUserGroupReq;
import website.chatx.dto.res.userchannel.list.ListMemberRes;

public interface UserChannelService {

    CommonListResponse<ListMemberRes> getListMember(String channelId, String search, UserChannelStatusEnum status, Integer page, Integer size);

    void addUserFriend(AddUserFriendReq req);

    void reactUserFriend(String channelId, ReactUserFriendReq req);

    void addUserGroup(String channelId, AddUserGroupReq req);

    void reactUserGroup(String channelId, ReactUserGroupReq req);
}
