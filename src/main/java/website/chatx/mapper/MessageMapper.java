package website.chatx.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.res.MessageRes;
import website.chatx.entities.MessageEntity;

@Mapper(componentModel = "spring")
public abstract class MessageMapper implements BaseCustomMapper {
    @Mapping(target = "messageFiles", ignore = true)
    @Mapping(target = "sender", ignore = true)
    @Mapping(target = "channel", ignore = true)
    public abstract MessageRes toMessageRes(MessageEntity entity);
}
