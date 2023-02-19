package cn.geekhall.hela.utils.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author yiny
 * @date 2023/2/6 22:01
 */
public class SHAUtil {
    /**
     * MD5 encryption.
     */
    public static String encode(String str) throws NoSuchAlgorithmException{
        MessageDigest.getInstance("SHA-1").update(str.getBytes());
        return Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-1").digest());
    }
}
