package website.chatx.dto.res.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import website.chatx.base.BaseResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MessageFileRes extends BaseResponse {

    private String name;

    private String url;

    private String contentType;

    private Integer size;

    private MessageRes message;

    private ChannelRes channel;
}
