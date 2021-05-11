package com.example.demo.Service;

import com.example.demo.DTO.ImagesDTO;
import com.example.demo.Entity.Images;
import com.example.demo.Repository.ImagesRepository;
import lombok.AllArgsConstructor;
import org.bson.types.Binary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ImagesService {
    private final ImagesRepository imagesRepository;

    public ImagesDTO addImage(MultipartFile file) {
        byte[] data = new byte[0];
        try {
            data = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data.length == 0) {
            throw new IllegalArgumentException();
        }

        Binary bData = new Binary(data);
        Images image = Images.builder().publicationData(bData).build();

        imagesRepository.save(image);

        return ImagesDTO.builder()
                .imagesId(image.getId())
                .build();
    }

    public Resource getById(String imageId) throws Exception {
        Images images = imagesRepository.findById(imageId)
                .orElseThrow(() -> new Exception("Post Image with " + imageId + " doesn't exists!"));
        return new ByteArrayResource(images.getPublicationData().getData());
    }
}
