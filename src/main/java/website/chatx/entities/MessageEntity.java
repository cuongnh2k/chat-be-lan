package website.chatx.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import website.chatx.base.BaseEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "message")
public class MessageEntity extends BaseEntity {

    private String receiverId;

    private String content;

    @OneToMany(mappedBy = "message")
    private List<MessageFileEntity> messageFiles;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private ChannelEntity channel;
}
