package website.chatx.dto.res.jpa;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInRes {
    private String token;
}
