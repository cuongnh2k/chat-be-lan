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
@Table(name="chanel")
public class ChanelEntity {

    @Id
    @Column(length = 36)
    private String id;

    private String chanelOwner;

    private String name;

    private String avatarUrl;

    private Integer numberAmount;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "chanel")
    private Collection<UserChanelEntity> userChanel;

    @OneToMany(mappedBy = "chanel")
    private Collection<MessageFileEntity> messageFiles;

    @OneToMany(mappedBy = "chanel")
    private Collection<MessageEntity> messages;
}
