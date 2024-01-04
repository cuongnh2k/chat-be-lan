package website.chatx.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.res.ChannelRes;
import website.chatx.entities.ChannelEntity;

@Mapper(componentModel = "spring")
public abstract class ChannelMapper implements BaseCustomMapper {

    @Mapping(target = "userChannels", ignore = true)
    @Mapping(target = "messageFiles", ignore = true)
    @Mapping(target = "messages", ignore = true)
    public abstract ChannelRes toChannelRes(ChannelEntity entity);
}