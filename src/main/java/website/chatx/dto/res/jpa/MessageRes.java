package website.chatx.dto.res.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import website.chatx.core.base.BaseResponse;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MessageRes extends BaseResponse {

    private String receiverId;

    private String content;

    private List<MessageFileRes> messageFiles;

    private UserRes sender;

    private ChannelRes channel;
}
