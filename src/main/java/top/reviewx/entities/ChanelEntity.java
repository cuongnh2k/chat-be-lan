package top.reviewx.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuperBuilder
@Entity
@Table(name="chanel")
public class ChanelEntity {

    private String chanelOwner;

    private String name;

    private String avatarUrl;

    @OneToMany(mappedBy = "chanel")
    private Collection<UserChanelEntity> userChanel;

    @OneToMany(mappedBy = "chanel")
    private Collection<MessageFileEntity> messageFiles;

    @OneToMany(mappedBy = "chanel")
    private Collection<MessageEntity> messages;
}
