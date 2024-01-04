package website.chatx.dto.res;

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
public class UserRes extends BaseResponse {

    private String email;

    private String name;

    private Boolean gender;

    private String phone;

    private String address;

    private String avatarUrl;

    private boolean isActivated;

    private List<UserActivationCodeRes> userActivationCodes;

    private List<UserChannelRes> userChannels;

    private List<MessageRes> userMessages;

    private List<FileUpRes> userFiles;
}
