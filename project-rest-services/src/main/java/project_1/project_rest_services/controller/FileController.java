package project_1.project_rest_services.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project_1.project_rest_services.service.FileService;

@RestController
@RequestMapping("/api/files")
public class FileController {
    private final FileService fileStorageService;

    @Autowired
    public FileController(FileService service){
        this.fileStorageService = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        String message=fileStorageService.storeFile(file);
        return ResponseEntity.ok(message);
    }

}
