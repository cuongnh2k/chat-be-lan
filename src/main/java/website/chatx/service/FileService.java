package website.chatx.service;

import org.springframework.web.multipart.MultipartFile;
import website.chatx.dto.res.entity.FileUpEntityRes;

public interface FileService {

    FileUpEntityRes uploadFile(MultipartFile file);

    void deleteFile(String fileId);


}
