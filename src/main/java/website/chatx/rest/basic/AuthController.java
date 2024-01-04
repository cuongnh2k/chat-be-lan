package website.chatx.rest.basic;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import website.chatx.core.common.CommonResponse;
import website.chatx.dto.auth.req.ActiveUserReq;
import website.chatx.dto.auth.req.ResetPasswordReq;
import website.chatx.dto.auth.req.SignInReq;
import website.chatx.dto.auth.req.SignUpReq;
import website.chatx.service.UserService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/basic/auths")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<CommonResponse> signUp(@RequestBody @Valid SignUpReq req) {
        userService.signUp(req);
        return CommonResponse.success("");
    }

    @PostMapping("/login")
    public ResponseEntity<CommonResponse> signIn(@RequestBody @Valid SignInReq req) {
        return CommonResponse.success(userService.signIn(req));
    }

    @PostMapping("/active")
    public ResponseEntity<CommonResponse> active(@RequestBody @Valid ActiveUserReq req) {
        userService.active(req);
        return CommonResponse.success("");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<CommonResponse> resetPassword(@RequestBody @Valid ResetPasswordReq req) {
        userService.resetPassword(req);
        return CommonResponse.success("");
    }
}
