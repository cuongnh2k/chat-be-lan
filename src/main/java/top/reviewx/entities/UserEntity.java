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
@Table(name="user")
public class UserEntity {

    @Id
    @Column(length = 36)
    private String id;

    private String email;

    @Column(columnDefinition = "text")
    private String password;

    private String username;

    private Boolean gender;

    private Integer phone;

    private String address;

    private String avatar;

    private Boolean isActivated;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    @OneToMany(mappedBy = "user")
    private Collection<UserActivationCodeEntity> userActivationCodes;

    @OneToMany(mappedBy = "user")
    private Collection<UserChanelEntity> userChannels;

    @OneToMany(mappedBy = "user")
    private Collection<MessageEntity> userMessages;

    @OneToMany(mappedBy = "user")
    private Collection<FileUpEntity> userFiles;

    @OneToMany(mappedBy = "user")
    private Collection<ContactEntity> userContacts;
}
