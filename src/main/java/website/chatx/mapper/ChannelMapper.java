package website.chatx.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.base.BaseCustomMapper;
import website.chatx.dto.res.jpa.ChannelRes;
import website.chatx.entities.ChannelEntity;

@Mapper(componentModel = "spring")
public abstract class ChannelMapper implements BaseCustomMapper {

    @Mapping(target = "userChannels", ignore = true)
    @Mapping(target = "messageFiles", ignore = true)
    @Mapping(target = "messages", ignore = true)
    public abstract ChannelRes toChannelRes(ChannelEntity entity);
}
