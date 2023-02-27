package cn.geekhall.hela.server.controller;

import cn.geekhall.hela.server.mapper.ImageMapper;
import cn.geekhall.hela.server.payload.response.ImageUploadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cn.geekhall.hela.server.entity.Image;

import java.io.IOError;
import java.io.IOException;

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
        Image image = new Image();
        image.setData(file.getBytes());
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setPath("http://localhost:8888/image/" + file.getOriginalFilename());
        imageMapper.insert(image);
        return null;
    }


}
