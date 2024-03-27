package com.fourflyairline.backendairlinebookingsystem.config;




import com.fourflyairline.backendairlinebookingsystem.exceptions.MediaUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
    String upload(MultipartFile multipartFile) throws  MediaUploadException;
}
