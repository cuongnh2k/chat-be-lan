package website.chatx.core.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.core.entities.UserChannelEntity;
import website.chatx.dto.res.jpa.UserChannelRes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-05T01:04:10+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserChannelMapperImpl extends UserChannelMapper {

    @Override
    public UserChannelRes toUserChannelRes(UserChannelEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserChannelRes.UserChannelResBuilder<?, ?> userChannelRes = UserChannelRes.builder();

        userChannelRes.id( entity.getId() );
        userChannelRes.createdAt( map( entity.getCreatedAt() ) );
        userChannelRes.updatedAt( map( entity.getUpdatedAt() ) );
        userChannelRes.createdBy( entity.getCreatedBy() );
        userChannelRes.updatedBy( entity.getUpdatedBy() );
        userChannelRes.status( entity.getStatus() );

        return userChannelRes.build();
    }
}
