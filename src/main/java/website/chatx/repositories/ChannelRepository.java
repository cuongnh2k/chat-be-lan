package website.chatx.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.chatx.core.entities.ChannelEntity;
import website.chatx.core.enums.ChannelTypeEnum;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelEntity, String> {
    Page<ChannelEntity> findByTypeAndNameContaining(ChannelTypeEnum type, String name, Pageable pageable);

    Page<ChannelEntity> findByType(ChannelTypeEnum type, Pageable pageable);
}
