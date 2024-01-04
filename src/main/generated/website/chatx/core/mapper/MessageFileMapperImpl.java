package website.chatx.core.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.core.entities.MessageFileEntity;
import website.chatx.dto.res.jpa.MessageFileRes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-05T01:04:10+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class MessageFileMapperImpl extends MessageFileMapper {

    @Override
    public MessageFileRes toMessageFileRes(MessageFileEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MessageFileRes.MessageFileResBuilder<?, ?> messageFileRes = MessageFileRes.builder();

        messageFileRes.id( entity.getId() );
        messageFileRes.createdAt( map( entity.getCreatedAt() ) );
        messageFileRes.updatedAt( map( entity.getUpdatedAt() ) );
        messageFileRes.createdBy( entity.getCreatedBy() );
        messageFileRes.updatedBy( entity.getUpdatedBy() );
        messageFileRes.name( entity.getName() );
        messageFileRes.url( entity.getUrl() );
        messageFileRes.contentType( entity.getContentType() );
        messageFileRes.size( entity.getSize() );

        return messageFileRes.build();
    }
}
