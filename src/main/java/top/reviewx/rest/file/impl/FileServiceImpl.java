package top.reviewx.rest.file.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.reviewx.core.base.BaseCreatedBy;
import top.reviewx.core.common.CommonAuthContext;
import top.reviewx.core.exception.AccessDeniedException;
import top.reviewx.core.exception.BusinessLogicException;
import top.reviewx.entities.FileUpEntity;
import top.reviewx.rest.file.FileRepository;
import top.reviewx.rest.file.FileService;
import top.reviewx.rest.file.dto.UploadFileRes;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final CommonAuthContext authContext;
    private final AmazonS3 amazonS3;

    @Value("${application.bucket.public}")
    private String BUCKET_PUBLIC;
    @Value("${cloud.aws.region.static}")
    private String REGION;

    private final Log LOGGER = LogFactory.getLog(getClass());
    @Override
    public UploadFileRes uploadFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String fileExtension = "";
        if (originalFilename != null) {
            fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        }
        if (fileExtension.isEmpty()) {
            throw new BusinessLogicException();
        }
        String id = UUID.randomUUID().toString();
        FileUpEntity fileEntity = FileUpEntity.builder()
                .fileUrl("https://s3." + REGION + ".amazonaws.com/" + BUCKET_PUBLIC + "/" + authContext.getId() + "/" + id + "." + fileExtension.toLowerCase())
                .nameFile(originalFilename.toLowerCase())
                .size(file.getSize())
                .contentType(file.getContentType())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        fileRepository.save(fileEntity);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        try {
            amazonS3.putObject(BUCKET_PUBLIC,
                    authContext.getId() + "/" + fileEntity.getId() + "." + fileExtension.toLowerCase(),
                    file.getInputStream(),
                    metadata);
        } catch (IOException e) {
            LOGGER.error(e);
            throw new BusinessLogicException();
        }
        return UploadFileRes.builder()
                .id(fileEntity.getId())
                .nameFile(fileEntity.getNameFile())
                .size(fileEntity.getSize())
                .fileUrl(fileEntity.getFileUrl())
                .build();
    }

//    @Override
//    public String deleteFile(String fileId) {
//        FileUpEntity fileEntity = fileRepository.findById(fileId).orElse(null);
//        if (fileEntity == null) {
//            throw new BusinessLogicException();
//        }
//        if (!fileEntity.getCreatedBy().getId().equals(authContext.getId())) {
//            throw new AccessDeniedException();
//        }
//        fileRepository.deleteById(fileId);
//        amazonS3.deleteObject(BUCKET_PUBLIC,
//                fileEntity.getCreatedBy().getId() + "/" + fileEntity.getId() + fileEntity.getName().substring(fileEntity.getName().lastIndexOf(".")));
//        return fileId;
//    }
}
