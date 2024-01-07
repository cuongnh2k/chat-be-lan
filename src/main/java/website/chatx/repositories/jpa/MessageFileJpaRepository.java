package website.chatx.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.chatx.core.entities.MessageFileEntity;

@Repository
public interface MessageFileJpaRepository extends JpaRepository<MessageFileEntity, String> {
}
