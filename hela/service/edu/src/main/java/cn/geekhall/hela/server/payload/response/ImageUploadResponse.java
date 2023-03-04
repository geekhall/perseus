package cn.geekhall.hela.server.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * ImageUploadResponse
 *
 * @author yiny
 * @date 2023/2/26 11:16
 */
@Getter
@Setter
@AllArgsConstructor
public class ImageUploadResponse {
    private String name;
    private String type;
    private String url;

    private String message;

    public ImageUploadResponse(String message) {
        this.message = message;
    }
}
