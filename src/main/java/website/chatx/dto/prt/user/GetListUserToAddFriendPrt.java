package website.chatx.dto.prt.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetListUserToAddFriendPrt {
    private String userId;
    private String search;
    private int offset;
    private int limit;
}
