package website.chatx.rest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import website.chatx.core.common.CommonResponse;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.service.ChannelService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/channels")
public class ChannelController {

    private final ChannelService channelService;

    @GetMapping
    public ResponseEntity<CommonResponse> search(@RequestParam(required = false) ChannelTypeEnum type,
                                                 @RequestParam(defaultValue = "") String name,
                                                 @RequestParam(defaultValue = "1") Integer page,
                                                 @RequestParam(defaultValue = "10") Integer size) {
        return CommonResponse.success(channelService.search(type, name, page, size));
    }

    @GetMapping("/{channelId}")
    public ResponseEntity<CommonResponse> detail(@PathVariable String channelId) {
        return CommonResponse.success(channelService.detail(channelId));
    }
}
