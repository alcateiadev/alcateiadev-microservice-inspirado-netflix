package com.br.alcateiadev.netflix.netflixpocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DownloadService {

    @Autowired
    private S3Service s3Service;

    @Value("${video.path}")
    private String path;

    @Value("${video.size}")
    private String size;

    @Value("${video.ext}")
    private String ext;

    public VideoItem execute() throws IOException {
        return VideoItem
                .builder()
                .video(s3Service.execute(path))
                .size(Long.parseLong(size))
                .ext(ext)
                .build();
    }

}