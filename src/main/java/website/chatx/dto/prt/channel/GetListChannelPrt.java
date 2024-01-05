package website.chatx.dto.prt.channel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetListChannelPrt {
    private String userId;
    private int offset;
    private int limit;
}
