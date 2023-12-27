package website.chatx.mapper;

import org.mapstruct.Mapper;
import website.chatx.core.base.BaseCustomMapper;
import website.chatx.dto.file.res.UploadFileRes;
import website.chatx.entities.FileUpEntity;

@Mapper(componentModel = "spring")
public abstract class FileUpMapper implements BaseCustomMapper {
    public abstract UploadFileRes toUploadFileRes(FileUpEntity fileUpEntity);
}
