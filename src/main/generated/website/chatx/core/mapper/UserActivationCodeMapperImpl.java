package website.chatx.core.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.core.entities.UserActivationCodeEntity;
import website.chatx.dto.res.entity.UserActivationCodeEntityRes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-11T23:17:54+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserActivationCodeMapperImpl extends UserActivationCodeMapper {

    @Override
    public UserActivationCodeEntityRes toUserActivationCodeRes(UserActivationCodeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserActivationCodeEntityRes.UserActivationCodeEntityResBuilder<?, ?> userActivationCodeEntityRes = UserActivationCodeEntityRes.builder();

        userActivationCodeEntityRes.id( entity.getId() );
        userActivationCodeEntityRes.createdAt( map( entity.getCreatedAt() ) );
        userActivationCodeEntityRes.updatedAt( map( entity.getUpdatedAt() ) );
        userActivationCodeEntityRes.createdBy( entity.getCreatedBy() );
        userActivationCodeEntityRes.updatedBy( entity.getUpdatedBy() );
        userActivationCodeEntityRes.code( entity.getCode() );

        return userActivationCodeEntityRes.build();
    }
}
