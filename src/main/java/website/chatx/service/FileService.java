package website.chatx.service;

import org.springframework.web.multipart.MultipartFile;
import website.chatx.dto.file.res.UploadFileRes;

public interface FileService {

    UploadFileRes uploadFile(MultipartFile file);

    void deleteFile(String fileId);
}
