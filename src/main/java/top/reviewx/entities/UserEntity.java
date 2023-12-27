package top.reviewx.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import top.reviewx.core.base.BaseEntity;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuperBuilder
@Entity
@Table(name="user")
public class UserEntity extends BaseEntity {

    private String email;

    @Column(columnDefinition = "text")
    private String password;

    private String username;

    private Boolean gender;

    private Integer phone;

    private String address;

    private String avatar;

    private Boolean isActivated;

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
