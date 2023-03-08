package cn.geekhall.hela.server.controller;


import cn.geekhall.hela.server.service.IFileUploadService;
import cn.geekhall.hela.server.service.impl.FileUploadServiceImpl;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * FileUploadController
 *
 * @author yiny
 * @date 2023/2/28 12:52
 */
@RestController
@CrossOrigin()
@RequestMapping("/test/upload")
public class FileUploadController {

    @Autowired
    IFileUploadService fileUploadService;

    @RequestMapping("/file")
    public Map<String, Object> singleFileUploadToPath(@RequestParam("file") MultipartFile file,
                                                      @RequestParam("path") String path)
                                                        throws IOException {
        Map<String, Object> result = new HashMap<>(16);
        return fileUploadService.singleFileUpload(file, path);
    }
}
