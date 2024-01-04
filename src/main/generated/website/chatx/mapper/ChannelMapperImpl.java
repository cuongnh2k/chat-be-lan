package website.chatx.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.dto.res.ChannelRes;
import website.chatx.entities.ChannelEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T02:55:10+0700",
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
