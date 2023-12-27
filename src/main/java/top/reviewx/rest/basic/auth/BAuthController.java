package top.reviewx.rest.basic.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/basic/auths")
public class BAuthController {
//    private final BUserService bUserService;
//
//    @PostMapping("/sign-up")
//    public ResponseEntity<CommonResponse> signUp(@RequestBody @Valid SignUpReq req,
//                                                 @RequestHeader(name = "api-key") @NotBlank String apiKey) {
//        return CommonResponse.success(bUserService.signUp(req));
//    }
//
//    @PostMapping("/sign-in")
//    public ResponseEntity<CommonResponse> signIn(@RequestBody @Valid SignInReq req,
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
