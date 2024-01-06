package website.chatx.dto.prt.userchannel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetListMemberPrt {
    private String userId;
    private String channelId;
    private String name;
    private int offset;
    private int limit;
}
