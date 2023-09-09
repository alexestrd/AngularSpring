package com.backend.backend.services;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

    @Value("${media.location}")
    private String mediaLocation;

    private Path rootLocation;

    @Override
    @PostConstruct
    public void init() throws IOException {
        rootLocation = Paths.get(mediaLocation);
        Files.createDirectories(rootLocation);

    }

    @Override
    public String store(MultipartFile file) throws IOException {

        try{
            String fileOriginalName = file.getOriginalFilename();
            if (file.isEmpty()){
                throw new RuntimeException("No se puede almacenar un archivo vacio");
            }
            String filenameencrip = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = filenameencrip + fileExtension;
            Path destinationFile = rootLocation.resolve(Paths.get(newFileName))
                    .normalize().toAbsolutePath();
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return newFileName;
        }catch (IOException e){
            throw new RuntimeException("Fallo al subir el archivo", e);

        }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try{
            Path file =rootLocation.resolve(filename);
            Resource resource = new UrlResource((file.toUri()));

            if (resource.exists() || resource.isReadable()){
                return resource;
            }else {
                throw new RuntimeException("no se pudo leer el archivo" + filename);
            }
        }catch (MalformedURLException e){
            throw new RuntimeException("no se pudo leer el archivo" + filename);
        }
    }

    @Override
    public Stream<Path> loadALl() {
        return null;
    }

    @Override
    public String deleteFile(String filename) {
        return null;
    }
}
