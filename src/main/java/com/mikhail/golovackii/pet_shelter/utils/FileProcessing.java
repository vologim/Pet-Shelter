package com.mikhail.golovackii.pet_shelter.utils;

import com.mikhail.golovackii.pet_shelter.exceptions.BadRequestException;
import com.mikhail.golovackii.pet_shelter.exceptions.ContentTypeFileException;
import com.mikhail.golovackii.pet_shelter.exceptions.FileExistsException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileProcessing {

    @Value("${file.storage}")
    private String filePath;

    public String saveFile(MultipartFile multipartFile, String entityType, String entityName)
            throws IOException {

        if (multipartFile.isEmpty()) {
            throw new BadRequestException();
        }

        if (!multipartFile.getContentType().equals("image/jpeg")) {
            throw new ContentTypeFileException();
        }

        String destination = filePath + "/" + entityType + "/" + entityName + "_" + multipartFile.getOriginalFilename();

        if (Files.exists(Paths.get(destination))) {
            throw new FileExistsException();
        }

        multipartFile.transferTo(new File(destination));

        return destination;
    }

}
