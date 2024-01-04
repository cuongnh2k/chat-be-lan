package website.chatx.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.res.jpa.FileUpRes;
import website.chatx.core.entities.FileUpEntity;

@Mapper(componentModel = "spring")
public abstract class FileUpMapper implements BaseCustomMapper {
    @Mapping(target = "user", ignore = true)
    public abstract FileUpRes toFileUpRes(FileUpEntity entity);
}