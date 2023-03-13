package com.lcwd.electronic.store.services.impl;

import com.lcwd.electronic.store.exceptions.BadApiRequest;
import com.lcwd.electronic.store.services.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    @Override
    public String uploadFile(MultipartFile file, String path) throws IOException {

        String originalFilename = file.getOriginalFilename();
        logger.info("Filename:{}", originalFilename);
        String filename = UUID.randomUUID().toString();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileNameWithExtention = filename+extension;
        String fullPathWithFileName = path+fileNameWithExtention;
        logger.info("full image path:{}",fullPathWithFileName);
        if(extension.equalsIgnoreCase(".png")
                || extension.equalsIgnoreCase(".jpg")
                || extension.equalsIgnoreCase(".jpeg")
        ){
            // file save
            logger.info("file extension is {}",extension);
            File folder = new File(path);
            if(!folder.exists()){
                //create folder
                folder.mkdirs();
            }
            //upload
            Files.copy(file.getInputStream(), Paths.get(fullPathWithFileName));
            return fileNameWithExtention;

        }else{
            throw new BadApiRequest("File With this "+extension+" not allowed !!");
        }
    }

    @Override
    public InputStream getResource(String path, String name) throws FileNotFoundException {
        String fullPath = path+File.separator+name;
        InputStream inputStream = new FileInputStream(fullPath);
        return inputStream;
    }
}
