package website.chatx.dto.res.channel;

import lombok.*;
import website.chatx.core.enums.ChannelTypeEnum;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailChannelRes {
    private String id;
    private String name;
    private String avatarUrl;
    private ChannelTypeEnum type;
}
