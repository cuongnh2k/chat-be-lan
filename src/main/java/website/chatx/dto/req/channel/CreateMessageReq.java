package website.chatx.dto.req.channel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateMessageReq {

    private String content;
    private List<File> files;

    @Getter
    @Setter
    public class File {
        private String url;
        private String name;
        private String contentType;
        private Integer size;
    }
}
