package website.chatx.dto.res.channel.list;

import lombok.*;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.core.enums.UserChannelStatusEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListChannelRes {
    private String id;
    private String friendId;
    private String name;
    private String avatarUrl;
    private ChannelTypeEnum type;
    private UserChannelStatusEnum status;
    private Long createdAt;
    private Long updatedAt;
    private CurrentMessageRes currentMessage;
}
