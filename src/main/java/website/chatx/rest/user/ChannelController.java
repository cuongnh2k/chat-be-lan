package website.chatx.rest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import website.chatx.common.CommonResponse;
import website.chatx.utils.PageableUtil;
import website.chatx.enums.ChannelTypeEnum;
import website.chatx.service.ChannelService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/channels")
public class ChannelController {

    private final ChannelService channelService;

    @GetMapping
    public ResponseEntity<CommonResponse> search(@RequestParam ChannelTypeEnum type,
                                                 @RequestParam(defaultValue = "") String name,
                                                 @RequestParam(defaultValue = "0") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer size,
                                                 @RequestParam(required = false) String sort) {
        return CommonResponse.success(channelService.search(type, name, PageableUtil.buildPageable(page, size, sort)));
    }
}
