package website.chatx.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.chatx.core.entities.UserEntity;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByEmail(String email);
}
