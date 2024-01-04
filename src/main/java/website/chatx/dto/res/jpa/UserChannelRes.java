package website.chatx.dto.res.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import website.chatx.core.base.BaseResponse;
import website.chatx.core.enums.UserChannelStatusEnum;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserChannelRes extends BaseResponse {

    private UserChannelStatusEnum status;

    private UserRes user;

    private ChannelRes channel;
}
