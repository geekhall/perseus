package cn.geekhall.hela.server.controller;

import cn.geekhall.hela.server.mapper.ImageMapper;
import cn.geekhall.hela.server.payload.response.ImageUploadResponse;
import cn.geekhall.hela.server.util.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import cn.geekhall.hela.server.entity.Image;

import javax.swing.text.html.Option;
import java.io.IOError;
import java.io.IOException;
import java.util.Optional;

/**
 * ImageController
 *
 * @author yiny
 * @date 2023/2/26 11:15
 */
@RestController
@CrossOrigin()
public class ImageController {

    @Autowired
    ImageMapper imageMapper;

    /**
     *
     * @param file
     * @return
     */
    @PostMapping("/upload/image")
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        imageMapper.insert(
                Image.builder().name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .data(ImageUtility.decompressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK).body(new ImageUploadResponse("Image uploaded successfully: " + file.getOriginalFilename()));
    }

    @GetMapping(path = {"/get/image/info/{name}"})
    public Image getImageDetails(@PathVariable("name") String name) throws IOException {
        final Optional<Image> dbImage = imageMapper.findByName(name);

        return Image.builder().name(dbImage.get().getName())
                .type(dbImage.get().getType()).data(ImageUtility.decompressImage(dbImage.get().getData())).build();
    }

    @GetMapping(path = {"/get/image/{name}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
        final Optional<Image> dbImage = imageMapper.findByName(name);

        return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getData()));
    }
}
