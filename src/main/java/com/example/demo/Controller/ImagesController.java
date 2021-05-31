package com.example.demo.Controller;

import com.example.demo.DTO.ImagesDTO;
import com.example.demo.Service.ImagesService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@AllArgsConstructor
public class ImagesController {
    private final ImagesService imagesService;

    @PostMapping
    public ImagesDTO addPostImage(@RequestParam("file") MultipartFile file) {
        return imagesService.addImage(file);
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<Resource> serveFile(@PathVariable String imageId) throws Exception {
        Resource resource = imagesService.getById(imageId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(resource);
    }
}
