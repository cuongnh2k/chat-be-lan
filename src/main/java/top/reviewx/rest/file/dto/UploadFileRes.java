package top.reviewx.rest.file.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UploadFileRes {
    private String id;
    private String nameFile;
    private Long size;
    private String fileUrl;
}
