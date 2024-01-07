package website.chatx.dto.req.channel;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserGroupReq {

    @NotBlank
    private String userId;
}
