package website.chatx.rest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import website.chatx.core.common.CommonResponse;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.service.ChannelService;
import website.chatx.service.MessageFileService;
import website.chatx.service.MessageService;
import website.chatx.service.UserChannelService;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/user/channels")
public class ChannelController {

    private final ChannelService channelService;
    private final MessageService messageService;
    private final MessageFileService messageFileService;
    private final UserChannelService userChannelService;

    @GetMapping
    public ResponseEntity<CommonResponse> getListChannel(@RequestParam(required = false) ChannelTypeEnum type,
                                                         @RequestParam(defaultValue = "") String search,
                                                         @RequestParam(required = false) Integer page,
                                                         @RequestParam(required = false) Integer size) {
        return CommonResponse.success(channelService.getListChannel(type, search, page, size));
    }

    @GetMapping("/{channelId}")
    public ResponseEntity<CommonResponse> getDetailChannel(@PathVariable String channelId) {
        return CommonResponse.success(channelService.getDetailChannel(channelId));
    }

    @GetMapping("/{channelId}/messages")
    public ResponseEntity<CommonResponse> getListMessage(@PathVariable String channelId,
                                                         @RequestParam(defaultValue = "") String content,
                                                         @RequestParam(required = false) Integer page,
                                                         @RequestParam(required = false) Integer size) {
        return CommonResponse.success(messageService.getListMessage(channelId, content, page, size));
    }

    @GetMapping("/{channelId}/files")
    public ResponseEntity<CommonResponse> getListFile(@PathVariable String channelId,
                                                      @RequestParam(defaultValue = "") String name,
                                                      @RequestParam(required = false) Integer page,
                                                      @RequestParam(required = false) Integer size) {
        return CommonResponse.success(messageFileService.getListFile(channelId, name, page, size));
    }

    @GetMapping("/{channelId}/member")
    public ResponseEntity<CommonResponse> getListMember(@PathVariable String channelId,
                                                        @RequestParam(defaultValue = "") String name,
                                                        @RequestParam(required = false) Integer page,
                                                        @RequestParam(required = false) Integer size) {
        return CommonResponse.success(userChannelService.getListMember(channelId, name, page, size));
    }
}
