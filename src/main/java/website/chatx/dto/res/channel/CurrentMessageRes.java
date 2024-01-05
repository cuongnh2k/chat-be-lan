package website.chatx.dto.res.channel;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentMessageRes {
    private String id;
    private String content;
    private SenderRes sender;
}
