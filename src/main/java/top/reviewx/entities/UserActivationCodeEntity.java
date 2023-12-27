package top.reviewx.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import top.reviewx.core.base.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuperBuilder
@Entity
@Table(name="user_activation_code")
public class UserActivationCodeEntity extends BaseEntity {

    private String code;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
