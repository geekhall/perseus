package cn.geekhall.hela.server.controller;

import cn.geekhall.hela.server.mapper.ImageMapper;
import cn.geekhall.hela.server.payload.response.ImageUploadResponse;
import cn.geekhall.hela.server.util.FileUtility;
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
    @PostMapping(value = "/test/upload/image", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam("image") MultipartFile file){
        ImageUploadResponse response = null;
        ResponseEntity<ImageUploadResponse> responseEntity = null;
        try {
            imageMapper.insert(
                    Image.builder().name(file.getOriginalFilename())
                            .type(file.getContentType())
                            .image(ImageUtility.decompressImage(file.getBytes())).build());
            response = new ImageUploadResponse("Image uploaded successfully: " + file.getOriginalFilename());
            response.setType(file.getContentType());
            response.setName(file.getOriginalFilename());
            response.setUrl(ImageUtility.uploadImage(file));

            responseEntity = ResponseEntity.status(HttpStatus.OK).body(response);
            System.out.println("Image uploaded successfully: " + file.getOriginalFilename());
            System.out.println("response: " + response);
            System.out.println("responseEntity: " + responseEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity;
    }

    @GetMapping(path = {"/get/image/info/{name}"})
    public Image getImageDetails(@PathVariable("name") String name) throws IOException {
        final Optional<Image> dbImage = imageMapper.findByName(name);

        return Image.builder().name(dbImage.get().getName())
                .type(dbImage.get().getType()).image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }

    @GetMapping(path = {"/get/image/{name}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) throws IOException {
        final Optional<Image> dbImage = imageMapper.findByName(name);

        return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageUtility.decompressImage(dbImage.get().getImage()));
    }
}
