package website.chatx.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import website.chatx.core.base.BaseResponse;
import website.chatx.enums.ChannelTypeEnum;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ChannelRes extends BaseResponse {

    private String ownerId;

    private String name;

    private String avatarUrl;

    private ChannelTypeEnum type;

    private List<UserChannelRes> userChannels;

    private List<MessageFileRes> messageFiles;

    private List<MessageRes> messages;
}
