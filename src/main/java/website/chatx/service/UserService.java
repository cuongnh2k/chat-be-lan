package website.chatx.service;

import website.chatx.core.common.CommonListResponse;
import website.chatx.dto.res.user.ListUserToAddFriendRes;

public interface UserService {
    CommonListResponse<ListUserToAddFriendRes> getListUserToAddFriend(String search, Integer page, Integer size);
}
