package website.chatx.core.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.core.entities.MessageEntity;
import website.chatx.dto.res.jpa.MessageRes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-05T01:04:10+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class MessageMapperImpl extends MessageMapper {

    @Override
    public MessageRes toMessageRes(MessageEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MessageRes.MessageResBuilder<?, ?> messageRes = MessageRes.builder();

        messageRes.id( entity.getId() );
        messageRes.createdAt( map( entity.getCreatedAt() ) );
        messageRes.updatedAt( map( entity.getUpdatedAt() ) );
        messageRes.createdBy( entity.getCreatedBy() );
        messageRes.updatedBy( entity.getUpdatedBy() );
        messageRes.receiverId( entity.getReceiverId() );
        messageRes.content( entity.getContent() );

        return messageRes.build();
    }
}
