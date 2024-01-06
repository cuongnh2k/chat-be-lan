package website.chatx.dto.rss.message.list;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListMessageFileRss {
    private String messageFileName;
    private String messageFileUrl;
    private String messageFileContentType;
    private Integer messageFileSize;
    private LocalDateTime messageFileCreatedAt;
    private LocalDateTime messageFileUpdatedAt;
}
