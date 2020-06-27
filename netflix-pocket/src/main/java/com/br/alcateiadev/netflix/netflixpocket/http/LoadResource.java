package com.br.alcateiadev.netflix.netflixpocket.http;

import com.br.alcateiadev.netflix.netflixpocket.service.DownloadService;
import com.br.alcateiadev.netflix.netflixpocket.service.VideoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v1")
public class LoadResource {

    @Autowired
    private DownloadService downloadService;

    @GetMapping(path = "/load", produces = "video/mp4")
    public ResponseEntity<InputStreamResource> create() throws ExecutionException, InterruptedException, IOException {

        VideoItem videoItem = downloadService.execute();

        InputStreamResource resource = new InputStreamResource(videoItem.getVideo());

        MediaType mediaType = MediaType.parseMediaType("video/mp4");
        long len = videoItem.getSize();

        return ResponseEntity.ok()
                .contentType(mediaType)
                .contentLength(len)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + videoItem.getExt() + "\"")
                .body(resource);
    }
}
