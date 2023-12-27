package top.reviewx.rest.basic.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.reviewx.entities.UserEntity;

@Repository
public interface BUserRepository extends JpaRepository<UserEntity, String> {
//    UserEntity findByLocal_Email(String email);
}
