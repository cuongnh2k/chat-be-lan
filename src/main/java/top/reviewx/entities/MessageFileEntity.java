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
@Table(name="message_file")
public class MessageFileEntity extends BaseEntity {

    private String nameFile;

    private Integer size;

    private String createBy;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private MessageEntity message;

    @ManyToOne
    @JoinColumn(name = "chanel_id")
    private ChanelEntity chanel;
}
