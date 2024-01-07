package website.chatx.dto.rss.user;

import lombok.*;
import website.chatx.core.enums.UserChannelStatusEnum;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusFriendRss {
    private String userId;
    private UserChannelStatusEnum status;
}
