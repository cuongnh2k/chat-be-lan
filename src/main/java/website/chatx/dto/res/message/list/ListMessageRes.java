package website.chatx.dto.res.message.list;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListMessageRes {
    private String id;
    private String content;

    private SenderRes sender;

    private List<ListMessageFileRes> listMessageFile;
}
