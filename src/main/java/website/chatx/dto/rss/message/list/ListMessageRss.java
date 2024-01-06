package website.chatx.dto.rss.message.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListMessageRss {
    private String id;
    private String content;

    private String senderId;
    private String senderEmail;
    private String senderName;
    private String senderAvatarUrl;

    private List<ListMessageFileRss> listMessageFile;
}
