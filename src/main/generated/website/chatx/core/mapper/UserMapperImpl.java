package website.chatx.core.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.core.entities.UserEntity;
import website.chatx.dto.res.jpa.UserRes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-05T01:04:10+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public UserRes toUserRes(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserRes.UserResBuilder<?, ?> userRes = UserRes.builder();

        userRes.id( entity.getId() );
        userRes.createdAt( map( entity.getCreatedAt() ) );
        userRes.updatedAt( map( entity.getUpdatedAt() ) );
        userRes.createdBy( entity.getCreatedBy() );
        userRes.updatedBy( entity.getUpdatedBy() );
        userRes.email( entity.getEmail() );
        userRes.name( entity.getName() );
        userRes.gender( entity.getGender() );
        userRes.phone( entity.getPhone() );
        userRes.address( entity.getAddress() );
        userRes.avatarUrl( entity.getAvatarUrl() );

        return userRes.build();
    }
}