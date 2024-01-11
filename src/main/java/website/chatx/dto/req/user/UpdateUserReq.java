package website.chatx.dto.req.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserReq {

    @NotBlank
    private String name;

    private String avatarUrl;

    private String newPassword;

    private String oldPassword;
}
