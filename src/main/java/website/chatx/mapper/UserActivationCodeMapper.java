package website.chatx.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.base.BaseCustomMapper;
import website.chatx.dto.res.jpa.UserActivationCodeRes;
import website.chatx.entities.UserActivationCodeEntity;

@Mapper(componentModel = "spring")
public abstract class UserActivationCodeMapper implements BaseCustomMapper {
    @Mapping(target = "user", ignore = true)
    public abstract UserActivationCodeRes toUserActivationCodeRes(UserActivationCodeEntity entity);
}
