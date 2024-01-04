package website.chatx.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.res.UserChannelRes;
import website.chatx.entities.UserChannelEntity;

@Mapper(componentModel = "spring")
public abstract class UserChannelMapper implements BaseCustomMapper {
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "channel", ignore = true)
    public abstract UserChannelRes toUserChannelRes(UserChannelEntity entity);
}
