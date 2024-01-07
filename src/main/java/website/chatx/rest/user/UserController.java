package website.chatx.rest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import website.chatx.core.common.CommonResponse;
import website.chatx.service.UserService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/to-add-friend")
    public ResponseEntity<CommonResponse> getUserToAddFriend(@RequestParam String email) {
        return CommonResponse.success(userService.getUserToAddFriend(email));
    }
}
