package com.example.demo.Controller;

import com.example.demo.DTO.PublicationDTO;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import com.example.demo.Service.PublicationService;
import com.example.demo.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/publication")
@AllArgsConstructor
public class PublicationController {
    private final PublicationService publicationService;
    private final UserService userService;

    @PostMapping("/addPost")
    public String get(@RequestParam("image") MultipartFile img,
                      @RequestParam("description") String des,
                      @RequestParam("userId")  String userId) throws IOException {
        File imgFile = new File("src/main/resources/static/images/" + img.getOriginalFilename());
        File imgTarget = new File("target/classes/static/images/" + img.getOriginalFilename());
        FileOutputStream o = new FileOutputStream(imgFile);
        FileOutputStream o2 = new FileOutputStream(imgTarget);
        o.write(img.getBytes());
        o2.write(img.getBytes());
        o2.close();
        o.close();
        Publication publication = new Publication(userService.getUser(), img.getOriginalFilename(), des);
        publicationService.save(publication);
        return "success";
    }

    @DeleteMapping("/{publicationId}")
    public ResponseEntity<Void> deletePostById(@PathVariable String publicationId, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        Publication publicationById = publicationService.findById(publicationId);
        if (publicationById.getUser().getId().equals(user.getId())) {
            if (publicationService.deletePost(publicationId)) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{userId}")
    public List<PublicationDTO> allPostsOfUser(@PathVariable String userId) throws Exception {
        return publicationService.publicationService(userId);
    }
}
