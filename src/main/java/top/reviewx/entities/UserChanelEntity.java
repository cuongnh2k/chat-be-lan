package top.reviewx.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import top.reviewx.core.base.BaseEntity;
import top.reviewx.core.enums.UserChanelEnum;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuperBuilder
@Entity
@Table(name="user_chanel")
public class UserChanelEntity extends BaseEntity {

    private UserChanelEnum status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "chanel_id")
    private ChanelEntity chanel;
}
