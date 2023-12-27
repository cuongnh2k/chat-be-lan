package top.reviewx.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="message")
public class MessageEntity {

    @Id
    @Column(length = 36)
    private String id;

    private String receiver;

    private String content;

    private String file;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private LocalDateTime deleteAt;

    @OneToMany(mappedBy = "message")
    private Collection<MessageFileEntity> messageFiles;

    @ManyToOne
    @JoinColumn(name = "sender")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "chane_id")
    private ChanelEntity chanel;
}
