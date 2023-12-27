package top.reviewx.rest.file;

import org.springframework.web.multipart.MultipartFile;
import top.reviewx.rest.file.dto.UploadFileRes;

public interface FileService {
    UploadFileRes uploadFile(MultipartFile file);

//    String deleteFile(String fileId);
}
