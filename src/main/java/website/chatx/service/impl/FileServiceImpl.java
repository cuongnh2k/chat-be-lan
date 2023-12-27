package website.chatx.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import website.chatx.core.common.CommonAuthContext;
import website.chatx.core.exception.AccessDeniedException;
import website.chatx.core.exception.BusinessLogicException;
import website.chatx.dto.file.res.UploadFileRes;
import website.chatx.entities.FileUpEntity;
import website.chatx.mapper.FileUpMapper;
import website.chatx.repositories.FileUpRepository;
import website.chatx.service.FileService;

import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileUpRepository fileUpRepository;

    private final CommonAuthContext authContext;

    private final AmazonS3 amazonS3;

    private final FileUpMapper fileUpMapper;

    @Value("${application.bucket.public}")
    private String BUCKET_PUBLIC;

    @Value("${cloud.aws.region.static}")
    private String REGION;

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

        FileUpEntity fileUpEntity = fileUpRepository.save(FileUpEntity.builder()
//                .url("https://s3." + REGION + ".amazonaws.com/" + BUCKET_PUBLIC + "/" + authContext.getUserEntity().getId() + "/" + id + "." + fileExtension.toLowerCase())
                .name(originalFilename.toLowerCase())
                .size(file.getSize())
                .contentType(file.getContentType())
                .user(authContext.getUserEntity())
                .build());
        fileUpEntity.setUrl("https://s3." + REGION + ".amazonaws.com/" + BUCKET_PUBLIC + "/" + authContext.getUserEntity().getId() + "/" + fileUpEntity.getId() + "." + fileExtension.toLowerCase());
        fileUpRepository.save(fileUpEntity);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        try {
            amazonS3.putObject(BUCKET_PUBLIC,
                    authContext.getUserEntity().getId() + "/" + fileUpEntity.getId() + "." + fileExtension.toLowerCase(),
                    file.getInputStream(),
                    metadata);
        } catch (IOException e) {
            throw new BusinessLogicException();
        }
        return fileUpMapper.toUploadFileRes(fileUpEntity);
    }

    @Override
    public void deleteFile(String fileId) {
        FileUpEntity fileUpEntity = fileUpRepository.findById(fileId).orElse(null);
        if (fileUpEntity == null) {
            throw new BusinessLogicException();
        }
        if (!fileUpEntity.getCreatedBy().equals(authContext.getUserEntity().getId())) {
            throw new AccessDeniedException();
        }
        fileUpRepository.deleteById(fileId);
        amazonS3.deleteObject(BUCKET_PUBLIC,
                authContext.getUserEntity().getId() + "/" + fileUpEntity.getId() + fileUpEntity.getName().substring(fileUpEntity.getName().lastIndexOf(".")));
    }
}