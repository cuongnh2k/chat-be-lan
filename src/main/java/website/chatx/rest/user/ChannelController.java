package website.chatx.rest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import website.chatx.core.common.CommonResponse;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.service.ChannelService;
import website.chatx.service.MessageService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/channels")
public class ChannelController {

    private final ChannelService channelService;
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<CommonResponse> getListChannel(@RequestParam(required = false) ChannelTypeEnum type,
                                                         @RequestParam(defaultValue = "") String name,
                                                         @RequestParam(defaultValue = "1") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size) {
        return CommonResponse.success(channelService.getListChannel(type, name, page, size));
    }

    @GetMapping("/{channelId}")
    public ResponseEntity<CommonResponse> getDetailChannel(@PathVariable String channelId) {
        return CommonResponse.success(channelService.getDetailChannel(channelId));
    }

    @GetMapping("/{channelId}/messages")
    public ResponseEntity<CommonResponse> getListMessage(@PathVariable String channelId,
                                                         @RequestParam(defaultValue = "") String content,
                                                         @RequestParam(defaultValue = "1") Integer page,
                                                         @RequestParam(defaultValue = "10") Integer size) {
        return CommonResponse.success(messageService.getListMessage(channelId, content, page, size));
    }
}
