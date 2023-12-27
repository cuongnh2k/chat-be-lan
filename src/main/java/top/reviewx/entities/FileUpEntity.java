package top.reviewx.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Where;
import top.reviewx.core.base.BaseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "file_up")
public class FileUpEntity extends BaseEntity {

    private String fileUrl;

    private String nameFile;

    private String contentType;

    private Long size;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity user;
}
