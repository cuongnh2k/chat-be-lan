package website.chatx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import website.chatx.entities.UserActivationCodeEntity;

public interface UserActivationCodeRepository extends JpaRepository<UserActivationCodeEntity, String> {
}
