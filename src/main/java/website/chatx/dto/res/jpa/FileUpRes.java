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
public class FileUpRes extends BaseResponse {

    private String url;

    private String name;

    private String contentType;

    private Long size;

    private UserRes user;
}
