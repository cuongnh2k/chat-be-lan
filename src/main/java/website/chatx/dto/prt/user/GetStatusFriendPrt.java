package website.chatx.dto.prt.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetStatusFriendPrt {
    private String userId;
    private String email;
}
