package website.chatx.service;

import website.chatx.dto.res.user.UserToAddFriendRes;

public interface UserService {
    UserToAddFriendRes getUserToAddFriend(String email);
}
