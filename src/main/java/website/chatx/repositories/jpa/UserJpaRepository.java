package website.chatx.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import website.chatx.core.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByEmail(String email);

    @Query("select u1 from UserEntity u1 where u1.email = :email and u1.isActivated = true and u1.id != :userId")
    Optional<UserEntity> findUserToAddFriend(@Param("email") String email, @Param("userId") String userId);
}
