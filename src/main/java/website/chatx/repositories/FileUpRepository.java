package website.chatx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.chatx.entities.FileUpEntity;
import website.chatx.entities.UserEntity;

@Repository
public interface FileUpRepository extends JpaRepository<FileUpEntity, String> {

    FileUpEntity findByIdAndUser(String id, UserEntity userEntity);
}
