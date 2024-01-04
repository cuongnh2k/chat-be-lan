package website.chatx.service;

import org.springframework.web.multipart.MultipartFile;
import website.chatx.dto.res.jpa.FileUpRes;

public interface FileService {

    FileUpRes uploadFile(MultipartFile file);

    void deleteFile(String fileId);
}
