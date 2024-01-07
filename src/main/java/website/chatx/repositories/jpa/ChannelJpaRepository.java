package website.chatx.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.chatx.core.entities.ChannelEntity;

@Repository
public interface ChannelJpaRepository extends JpaRepository<ChannelEntity, String> {
}
