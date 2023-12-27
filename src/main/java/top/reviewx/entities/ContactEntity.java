package top.reviewx.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import top.reviewx.core.base.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SuperBuilder
@Entity
@Table(name="contact")
public class ContactEntity extends BaseEntity {

    private Boolean status;

    private LocalDateTime createAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
