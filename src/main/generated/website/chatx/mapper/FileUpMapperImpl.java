package website.chatx.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.dto.file.res.UploadFileRes;
import website.chatx.entities.FileUpEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-28T02:29:47+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class FileUpMapperImpl extends FileUpMapper {

    @Override
    public UploadFileRes toUploadFileRes(FileUpEntity fileUpEntity) {
        if ( fileUpEntity == null ) {
            return null;
        }

        UploadFileRes.UploadFileResBuilder uploadFileRes = UploadFileRes.builder();

        uploadFileRes.id( fileUpEntity.getId() );
        uploadFileRes.name( fileUpEntity.getName() );
        uploadFileRes.size( fileUpEntity.getSize() );
        uploadFileRes.url( fileUpEntity.getUrl() );

        return uploadFileRes.build();
    }
}
