package cn.geekhall.hela.utils.crypto;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author yiny
 * @date 2023/2/6 22:01
 */
@Component
public class MD5Util {

    /**
     * MD5 encryption.
     */
    public static String encode(String str) throws NoSuchAlgorithmException{
        MessageDigest.getInstance("MD5").update(str.getBytes());
        return Base64.getEncoder().encodeToString(MessageDigest.getInstance("MD5").digest());
    }
}
