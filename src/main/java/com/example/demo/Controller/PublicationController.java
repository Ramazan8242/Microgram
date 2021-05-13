package com.example.demo.Controller;

import com.example.demo.DTO.PublicationDTO;
import com.example.demo.Entity.Publication;
import com.example.demo.Service.PublicationService;
import com.example.demo.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/publication")
@AllArgsConstructor
public class PublicationController {
    private final PublicationService publicationService;
    private final UserService userService;

    @PostMapping("/addPost")
    public void get(@RequestParam("image") MultipartFile img){
        this.publicationService.save((Publication) img);
    }

    @DeleteMapping("/{publicationId}")
    public boolean deletePostById(@PathVariable String publicationId){
        return this.publicationService.deletePost(publicationId);
    }

    @GetMapping("/{userId}")
    public List<PublicationDTO> allPostsOfUser(@PathVariable String userId) throws Exception {
        return publicationService.publicationService(userId);
    }
}
