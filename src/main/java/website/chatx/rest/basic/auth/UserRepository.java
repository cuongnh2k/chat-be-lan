package website.chatx.rest.basic.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.chatx.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
//    UserEntity findByLocal_Email(String email);
}
