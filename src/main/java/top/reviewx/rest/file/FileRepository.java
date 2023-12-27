package top.reviewx.rest.file;

import org.springframework.data.jpa.repository.JpaRepository;
import top.reviewx.entities.FileUpEntity;

public interface FileRepository extends JpaRepository<FileUpEntity, String> {
}
