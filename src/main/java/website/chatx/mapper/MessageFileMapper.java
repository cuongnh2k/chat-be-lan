package website.chatx.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.res.MessageFileRes;
import website.chatx.entities.MessageFileEntity;

@Mapper(componentModel = "spring")
public abstract class MessageFileMapper implements BaseCustomMapper {
    @Mapping(target = "message", ignore = true)
    @Mapping(target = "channel", ignore = true)
    public abstract MessageFileRes toMessageFileRes(MessageFileEntity entity);
}