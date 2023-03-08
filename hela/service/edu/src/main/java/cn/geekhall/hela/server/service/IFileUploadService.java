package cn.geekhall.hela.server.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface IFileUploadService {
    Map<String, Object> singleFileUpload(MultipartFile file, String path) throws IOException;
}
