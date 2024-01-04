package website.chatx.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import website.chatx.dto.res.FileUpRes;
import website.chatx.entities.FileUpEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T02:55:11+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class FileUpMapperImpl extends FileUpMapper {

    @Override
    public FileUpRes toFileUpRes(FileUpEntity entity) {
        if ( entity == null ) {
            return null;
        }

        FileUpRes.FileUpResBuilder<?, ?> fileUpRes = FileUpRes.builder();

        fileUpRes.id( entity.getId() );
        fileUpRes.createdAt( map( entity.getCreatedAt() ) );
        fileUpRes.updatedAt( map( entity.getUpdatedAt() ) );
        fileUpRes.createdBy( entity.getCreatedBy() );
        fileUpRes.updatedBy( entity.getUpdatedBy() );
        fileUpRes.url( entity.getUrl() );
        fileUpRes.name( entity.getName() );
        fileUpRes.contentType( entity.getContentType() );
        fileUpRes.size( entity.getSize() );

        return fileUpRes.build();
    }
}
