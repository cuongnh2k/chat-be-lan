package website.chatx.dto.prt.channel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import website.chatx.core.enums.ChannelTypeEnum;

@Getter
@Setter
@Builder
public class GetListChannelPrt {
    private String userId;
    private ChannelTypeEnum type;
    private String name;
    private int offset;
    private int limit;
}
