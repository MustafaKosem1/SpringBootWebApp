package com.ilan.demo.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/images")
public class ImageController {
    private final Path imageFolder = Paths.get("src", "main", "resources", "static", "images");
    @GetMapping("{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = imageFolder.resolve(imageName);
        Resource resource = new UrlResource(imagePath.toUri());
        return ResponseEntity.ok().header("Content-Type", "image/jpg").body(resource);
    }
}
