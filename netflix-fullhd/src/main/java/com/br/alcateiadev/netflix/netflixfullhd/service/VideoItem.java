package com.br.alcateiadev.netflix.netflixfullhd.service;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class VideoItem {
    private S3ObjectInputStream video;
    private long size;
    private String ext;
}
