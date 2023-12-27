package website.chatx.rest.basic.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import website.chatx.service.UserService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/basic/auths")
public class AuthController {

    private final UserService userService;

//    @PostMapping("/register")
//    public ResponseEntity<CommonResponse> register(@RequestBody @Valid SignUpReq req,
//                                                 @RequestHeader(name = "api-key") @NotBlank String apiKey) {
//        return CommonResponse.success(userService.signUp(req));
//    }

//    @PostMapping("/login")
//    public ResponseEntity<CommonResponse> login(@RequestBody @Valid SignInReq req,
//                                                 @RequestHeader(name = "api-key") @NotBlank String apiKey) {
//        return CommonResponse.success(bUserService.signIn(req));
//    }
//
//    @PostMapping("/active")
//    public ResponseEntity<CommonResponse> active(@RequestBody @Valid ActiveUserReq req,
//                                                 @RequestHeader(name = "api-key") @NotBlank String apiKey) {
//        return CommonResponse.success(bUserService.active(req));
//    }
//
//    @PostMapping("/reset-password")
//    public ResponseEntity<CommonResponse> resetPassword(@RequestBody @Valid ResetPasswordReq req,
//                                                        @RequestHeader(name = "api-key") @NotBlank String apiKey) {
//        return CommonResponse.success(bUserService.resetPassword(req));
//    }
}
