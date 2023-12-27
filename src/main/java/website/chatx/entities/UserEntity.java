package website.chatx.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import website.chatx.core.base.BaseEntity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    private String email;

    @Column(columnDefinition = "text")
    private String password;

    private String name;

    private Boolean gender;

    private String phone;

    private String address;

    private String avatarUrl;

    private Boolean isActivated;

    @OneToMany(mappedBy = "user")
    private List<UserActivationCodeEntity> userActivationCodes;

    @OneToMany(mappedBy = "user")
    private List<UserChannelEntity> userChannels;

    @OneToMany(mappedBy = "sender")
    private List<MessageEntity> userMessages;

    @OneToMany(mappedBy = "user")
    private List<FileUpEntity> userFiles;

    @OneToMany(mappedBy = "user")
    private List<ContactEntity> userContacts;
}
