package br.beck.azureblob.controller;

import br.beck.azureblob.service.BlobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private BlobService myBlobService;

    @PostMapping("/upload")
    public String uploadFile(MultipartFile file) throws IOException {
        myBlobService.storeFile(file.getOriginalFilename(),file.getInputStream(), file.getSize());
        return file.getOriginalFilename() + " Has been saved as a blob-item!!!";

    }
}
