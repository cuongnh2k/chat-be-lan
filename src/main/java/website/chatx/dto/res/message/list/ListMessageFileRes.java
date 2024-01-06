package website.chatx.dto.res.message.list;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListMessageFileRes {
    private String name;
    private String url;
    private String contentType;
    private Integer size;
}
