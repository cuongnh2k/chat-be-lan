package website.chatx.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.res.jpa.UserActivationCodeRes;
import website.chatx.core.entities.UserActivationCodeEntity;

@Mapper(componentModel = "spring")
public abstract class UserActivationCodeMapper implements BaseCustomMapper {
    @Mapping(target = "user", ignore = true)
    public abstract UserActivationCodeRes toUserActivationCodeRes(UserActivationCodeEntity entity);
}
