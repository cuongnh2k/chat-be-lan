package website.chatx.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.res.entity.MessageFileEntityRes;
import website.chatx.core.entities.MessageFileEntity;

@Mapper(componentModel = "spring")
public abstract class MessageFileMapper implements BaseCustomMapper {
    @Mapping(target = "message", ignore = true)
    @Mapping(target = "channel", ignore = true)
    public abstract MessageFileEntityRes toMessageFileRes(MessageFileEntity entity);
}
