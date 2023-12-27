package top.reviewx.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="message_file")
public class MessageFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameFile;

    private Integer size;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private String createBy;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private MessageEntity message;

    @ManyToOne
    @JoinColumn(name = "chanel_id")
    private ChanelEntity chanel;
}
