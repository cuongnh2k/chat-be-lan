package website.chatx.core.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.core.entities.ChannelEntity;
import website.chatx.dto.res.jpa.ChannelRes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-05T01:04:10+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class ChannelMapperImpl extends ChannelMapper {

    @Override
    public ChannelRes toChannelRes(ChannelEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ChannelRes.ChannelResBuilder<?, ?> channelRes = ChannelRes.builder();

        channelRes.id( entity.getId() );
        channelRes.createdAt( map( entity.getCreatedAt() ) );
        channelRes.updatedAt( map( entity.getUpdatedAt() ) );
        channelRes.createdBy( entity.getCreatedBy() );
        channelRes.updatedBy( entity.getUpdatedBy() );
        channelRes.ownerId( entity.getOwnerId() );
        channelRes.name( entity.getName() );
        channelRes.avatarUrl( entity.getAvatarUrl() );
        channelRes.type( entity.getType() );

        return channelRes.build();
    }
}
