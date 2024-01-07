package website.chatx.service;

import website.chatx.core.common.CommonListResponse;
import website.chatx.dto.res.user.OneUserToAddFriendRes;
import website.chatx.dto.res.user.ListFriendToAddGroupRes;

public interface UserService {
    OneUserToAddFriendRes getOneUserToAddFriend(String email);

    CommonListResponse<ListFriendToAddGroupRes> getListFriendToAddGroup(String channelId, String search, Integer page, Integer size);
}
