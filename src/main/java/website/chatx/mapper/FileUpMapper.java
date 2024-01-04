package website.chatx.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.res.FileUpRes;
import website.chatx.entities.FileUpEntity;

@Mapper(componentModel = "spring")
public abstract class FileUpMapper implements BaseCustomMapper {
    @Mapping(target = "user", ignore = true)
    public abstract FileUpRes toFileUpRes(FileUpEntity entity);
}
