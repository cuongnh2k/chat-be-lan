package website.chatx.dto.res.user;

import lombok.*;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.core.enums.UserChannelStatusEnum;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserToAddFriendRes {
    private String id;
    private String email;
    private String name;
    private String avatarUrl;
    private UserChannelStatusEnum theirStatus;
    private UserChannelStatusEnum myStatus;
}
