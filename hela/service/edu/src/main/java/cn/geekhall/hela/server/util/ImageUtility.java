package cn.geekhall.hela.server.util;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @author yiny
 * @date 2023/2/27 21:52
 */
public class ImageUtility {

    public static final String UPLOADS_PATH= "uploads/";
    public static final String PROJECT_ROOT_PATH = System.getProperty("user.dir");
    public static final String UPLOADS_ROOT_PATH = PROJECT_ROOT_PATH + "/" + UPLOADS_PATH;
    public static String uploadImage(MultipartFile file) throws Exception{
        final String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        final String fileName = UUID.randomUUID().toString()  + fileSuffix;

        final String filePath = UPLOADS_ROOT_PATH + fileName;
        System.out.println();
        File destFile = new File(filePath, fileName);
        file.transferTo(destFile);

        String url = UPLOADS_PATH + fileName;
        return url;
    }
    public static byte[] decompressImage(byte[] data) {
        return  null;
    }

    /** compress image to byte array
     * @param data
     * @return
     */
    public static byte[] compressImage(byte[] data) {
        return  null;
    }

    /**
     * save image from input stream to file.
     *
     * @param inputStream
     * @param filePath
     * @throws Exception
     */
    public static void saveStreamToFile(@NotNull final InputStream inputStream, @NotNull final String filePath) throws Exception{
        OutputStream outputStream = new FileOutputStream(filePath);
        byte[] buffer = new byte[1024];
        int length = 0;
        try {
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            outputStream.close();
            inputStream.close();
        }
    }


}
