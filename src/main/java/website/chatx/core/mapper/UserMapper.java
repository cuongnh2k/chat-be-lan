package website.chatx.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.res.entity.UserEntityRes;
import website.chatx.core.entities.UserEntity;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseCustomMapper {
    @Mapping(target = "userActivationCodes", ignore = true)
    @Mapping(target = "userChannels", ignore = true)
    @Mapping(target = "userMessages", ignore = true)
    @Mapping(target = "userFiles", ignore = true)
    public abstract UserEntityRes toUserRes(UserEntity entity);
}
