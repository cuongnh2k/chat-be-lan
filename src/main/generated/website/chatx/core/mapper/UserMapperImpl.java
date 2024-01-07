package website.chatx.core.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.core.entities.UserEntity;
import website.chatx.dto.res.entity.UserEntityRes;
import website.chatx.dto.res.user.UserToAddFriendRes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T11:22:51+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public UserEntityRes toUserEntityRes(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserEntityRes.UserEntityResBuilder<?, ?> userEntityRes = UserEntityRes.builder();

        userEntityRes.id( entity.getId() );
        userEntityRes.createdAt( map( entity.getCreatedAt() ) );
        userEntityRes.updatedAt( map( entity.getUpdatedAt() ) );
        userEntityRes.createdBy( entity.getCreatedBy() );
        userEntityRes.updatedBy( entity.getUpdatedBy() );
        userEntityRes.email( entity.getEmail() );
        userEntityRes.password( entity.getPassword() );
        userEntityRes.name( entity.getName() );
        userEntityRes.gender( entity.getGender() );
        userEntityRes.phone( entity.getPhone() );
        userEntityRes.address( entity.getAddress() );
        userEntityRes.avatarUrl( entity.getAvatarUrl() );

        return userEntityRes.build();
    }

    @Override
    public UserToAddFriendRes toUserToAddFriendRes(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserToAddFriendRes.UserToAddFriendResBuilder userToAddFriendRes = UserToAddFriendRes.builder();

        userToAddFriendRes.id( entity.getId() );
        userToAddFriendRes.email( entity.getEmail() );
        userToAddFriendRes.name( entity.getName() );
        userToAddFriendRes.avatarUrl( entity.getAvatarUrl() );

        return userToAddFriendRes.build();
    }
}
