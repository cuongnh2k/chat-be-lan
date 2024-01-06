package website.chatx.dto.res.channel.list;

import lombok.*;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.dto.res.channel.list.CurrentMessageRes;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListChannelRes {
    private String id;
    private String name;
    private String avatarUrl;
    private ChannelTypeEnum type;
    private Long createdAt;
    private Long updatedAt;
    private CurrentMessageRes currentMessage;
}
