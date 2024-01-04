package website.chatx.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.base.BaseCustomMapper;
import website.chatx.dto.res.jpa.UserRes;
import website.chatx.entities.UserEntity;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseCustomMapper {
    @Mapping(target = "userActivationCodes", ignore = true)
    @Mapping(target = "userChannels", ignore = true)
    @Mapping(target = "userMessages", ignore = true)
    @Mapping(target = "userFiles", ignore = true)
    public abstract UserRes toUserRes(UserEntity entity);
}
