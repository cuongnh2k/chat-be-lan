package website.chatx.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.chatx.core.entities.ChannelEntity;
import website.chatx.core.entities.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, String> {

    MessageEntity findFirstByChannelOrderByCreatedAtDesc(ChannelEntity channelEntity);
}
