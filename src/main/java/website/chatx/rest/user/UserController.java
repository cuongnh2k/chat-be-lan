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
    public ResponseEntity<CommonResponse> getListToAddFriend(@RequestParam(defaultValue = "") String search,
                                                             @RequestParam(required = false) Integer page,
                                                             @RequestParam(required = false) Integer size) {
        return CommonResponse.success(userService.getListUserToAddFriend(search, page, size));
    }
}
