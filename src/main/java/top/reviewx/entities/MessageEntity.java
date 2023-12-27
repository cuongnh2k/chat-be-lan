package top.reviewx.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import top.reviewx.core.base.BaseEntity;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuperBuilder
@Entity
@Table(name="message")
public class MessageEntity extends BaseEntity {

    private String receiver;

    private String content;

    @OneToMany(mappedBy = "message")
    private Collection<MessageFileEntity> messageFiles;

    @ManyToOne
    @JoinColumn(name = "sender")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "chane_id")
    private ChanelEntity chanel;
}
