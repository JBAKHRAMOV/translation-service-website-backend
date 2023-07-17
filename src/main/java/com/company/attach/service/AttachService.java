package com.company.attach.service;

import com.company.attach.dto.AttachUplRes;
import com.company.attach.entity.AttachEntity;
import com.company.attach.repository.AttachRepository;
import com.company.exp.AppBadRequestException;
import com.company.exp.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class AttachService {

    private final AttachRepository attachRepository;
    @Value("${attach.upload.fold")
    private String attachFolder;
    @Value("${server.domain.name}")
    private String domainName;

    public AttachUplRes upload(MultipartFile file) {
        String pathFolder = getYMDString();  // 2022/04/23
        File folder = new File(attachFolder + pathFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String extension = getExtension(Objects.requireNonNull(file.getOriginalFilename()));

        AttachEntity entity = saveAttach(pathFolder, extension, file);

        String key = entity.getId();


        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(attachFolder + pathFolder + "/" + key + "." + extension);
            Files.write(path, bytes);
        } catch (IOException e) {
            log.warn("Not upload {}", AttachService.class);
            throw new RuntimeException(e);
        }
        return new AttachUplRes(key, toOpenURL(key));
    }

    public byte[] openGeneral(String key) {
        byte[] data;
        try {
            AttachEntity entity = getById(key);
            String path = entity.getPath() + "/" + key + "." + entity.getExtension();
            Path file = Paths.get(attachFolder + path);
            data = Files.readAllBytes(file);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @SneakyThrows
    public Boolean delete(String key) {
        AttachEntity entity = getById(key);

        File file = new File(attachFolder + entity.getPath() +
                "/" + entity.getId() + "." + entity.getExtension());

        if (file.delete()) {
            attachRepository.deleteById(key);
            return true;
        }
        log.warn("Could not read the file!{}", AttachService.class);
        throw new AppBadRequestException("Could not read the file!");
    }
    
    private AttachEntity getById(String id) {
        return attachRepository.findById(id).orElseThrow(() -> {
            log.warn("Attach not found!{}", AttachService.class);
            return new ItemNotFoundException("Attach Not Found");
        });
    }

    private AttachEntity saveAttach(String pathFolder, String extension, MultipartFile file) {
        AttachEntity entity = new AttachEntity();
        entity.setPath(pathFolder);
        entity.setOriginName(file.getOriginalFilename());
        entity.setExtension(extension);
        entity.setSize(file.getSize());
        attachRepository.save(entity);
        return entity;
    }

    private String getExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        return fileName.substring(lastIndex + 1);
    }

    private String getYMDString() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DATE);

        return year + "/" + month + "/" + day; // 2022/04/23
    }

    private String toOpenURL(String id) {
        return domainName + "/attach/open_general/" + id;
    }
}
