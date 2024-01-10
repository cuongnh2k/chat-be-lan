package website.chatx.core.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.core.entities.MessageEntity;
import website.chatx.dto.res.entity.MessageEntityRes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-11T02:14:42+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class MessageMapperImpl extends MessageMapper {

    @Override
    public MessageEntityRes toMessageRes(MessageEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MessageEntityRes.MessageEntityResBuilder<?, ?> messageEntityRes = MessageEntityRes.builder();

        messageEntityRes.id( entity.getId() );
        messageEntityRes.createdAt( map( entity.getCreatedAt() ) );
        messageEntityRes.updatedAt( map( entity.getUpdatedAt() ) );
        messageEntityRes.createdBy( entity.getCreatedBy() );
        messageEntityRes.updatedBy( entity.getUpdatedBy() );
        messageEntityRes.content( entity.getContent() );

        return messageEntityRes.build();
    }
}
