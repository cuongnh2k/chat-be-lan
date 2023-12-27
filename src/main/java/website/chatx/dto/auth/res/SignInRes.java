package website.chatx.dto.auth.res;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInRes {
    private String token;
}
