package website.chatx.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.dto.res.UserActivationCodeRes;
import website.chatx.entities.UserActivationCodeEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T02:55:11+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserActivationCodeMapperImpl extends UserActivationCodeMapper {

    @Override
    public UserActivationCodeRes toUserActivationCodeRes(UserActivationCodeEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserActivationCodeRes.UserActivationCodeResBuilder<?, ?> userActivationCodeRes = UserActivationCodeRes.builder();

        userActivationCodeRes.id( entity.getId() );
        userActivationCodeRes.createdAt( map( entity.getCreatedAt() ) );
        userActivationCodeRes.updatedAt( map( entity.getUpdatedAt() ) );
        userActivationCodeRes.createdBy( entity.getCreatedBy() );
        userActivationCodeRes.updatedBy( entity.getUpdatedBy() );
        userActivationCodeRes.code( entity.getCode() );

        return userActivationCodeRes.build();
    }
}
