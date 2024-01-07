package website.chatx.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.chatx.core.entities.UserChannelEntity;
import website.chatx.core.enums.UserChannelStatusEnum;

@Repository
public interface UserChannelJpaRepository extends JpaRepository<UserChannelEntity, String> {

    Boolean existsByUserIdAndChannelIdAndStatus(String userId, String channelId, UserChannelStatusEnum status);
}
