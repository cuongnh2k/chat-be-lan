package top.reviewx.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="file_up")
public class FileUpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameFile;

    private String contentType;

    private String fileUrl;

    private Integer size;

    @ManyToOne
    @JoinColumn(name = "create_by")
    private UserEntity user;
}
