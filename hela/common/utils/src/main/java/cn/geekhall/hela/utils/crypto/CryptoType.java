package cn.geekhall.hela.utils.crypto;

/**
 * @author yiny
 * @date 2023/2/6 21:55
 */
public enum CryptoType {
    MD5("MD5"),
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA512("SHA-512");

    private String value;

    CryptoType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
