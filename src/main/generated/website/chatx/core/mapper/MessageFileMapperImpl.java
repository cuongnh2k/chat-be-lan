package website.chatx.core.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.core.entities.MessageFileEntity;
import website.chatx.dto.res.entity.MessageFileEntityRes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T18:05:41+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class MessageFileMapperImpl extends MessageFileMapper {

    @Override
    public MessageFileEntityRes toMessageFileRes(MessageFileEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MessageFileEntityRes.MessageFileEntityResBuilder<?, ?> messageFileEntityRes = MessageFileEntityRes.builder();

        messageFileEntityRes.id( entity.getId() );
        messageFileEntityRes.createdAt( map( entity.getCreatedAt() ) );
        messageFileEntityRes.updatedAt( map( entity.getUpdatedAt() ) );
        messageFileEntityRes.createdBy( entity.getCreatedBy() );
        messageFileEntityRes.updatedBy( entity.getUpdatedBy() );
        messageFileEntityRes.name( entity.getName() );
        messageFileEntityRes.url( entity.getUrl() );
        messageFileEntityRes.contentType( entity.getContentType() );
        messageFileEntityRes.size( entity.getSize() );

        return messageFileEntityRes.build();
    }
}
