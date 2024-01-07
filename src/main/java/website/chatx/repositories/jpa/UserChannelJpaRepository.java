package website.chatx.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import website.chatx.core.entities.UserChannelEntity;
import website.chatx.core.enums.UserChannelStatusEnum;

import java.util.List;

@Repository
public interface UserChannelJpaRepository extends JpaRepository<UserChannelEntity, String> {

    Boolean existsByUserIdAndChannelIdAndStatus(String userId, String channelId, UserChannelStatusEnum status);

    @Query(nativeQuery = true,
            value = """
                            select uc3.*
                            from channel c1
                                     join user_channel uc1 on (c1.id = uc1.channel_id and uc1.user_id = ?1 and c1.type = 'FRIEND')
                                     join user_channel uc2 on (c1.id = uc2.channel_id and uc2.user_id = ?2 and c1.type = 'FRIEND')
                                     join user_channel uc3 on (c1.id = uc3.channel_id and c1.type = 'FRIEND')
                    """)
    List<UserChannelEntity> findMyIdAndTheirId(String myId, String theirId);
}
