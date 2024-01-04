package website.chatx.dto.rss.channel;

import lombok.*;
import website.chatx.core.enums.ChannelTypeEnum;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListChannelRss {
    private String id;
    private String name;
    private String avatarUrl;
    private ChannelTypeEnum type;
    private MessageRes message;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class MessageRes {
        private String id;
        private String content;
        private List<MessageFileRes> messageFiles;
        private UserRes sender;

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public class UserRes {
            private String id;
            private String email;
            private String name;
            private String avatarUrl;
        }

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public class MessageFileRes {
            private String id;
            private String name;
            private String url;
            private String contentType;
            private Integer size;
        }
    }
}
