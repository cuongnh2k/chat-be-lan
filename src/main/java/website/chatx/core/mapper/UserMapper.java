package website.chatx.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.core.entities.UserEntity;
import website.chatx.dto.res.entity.UserEntityRes;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseCustomMapper {
    @Mapping(target = "userActivationCodes", ignore = true)
    @Mapping(target = "userChannels", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "fileUps", ignore = true)
    @Mapping(target = "messageFiles", ignore = true)
    public abstract UserEntityRes toUserRes(UserEntity entity);
}
