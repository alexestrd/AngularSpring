package com.backend.backend.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void init() throws IOException;

    String store(MultipartFile file) throws IOException;

    Resource loadAsResource(String filename);

    public Stream<Path> loadALl();

    public String deleteFile(String filename);
}
