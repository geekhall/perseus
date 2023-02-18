package cn.geekhall.hera.base.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * HeraMetaObjectHandler
 *
 * @author yiny
 * @date 2022/3/28 04:47
 */
@Component
public class HeraMetaObjectHandler implements MetaObjectHandler {
    /**
     * 使用MybatisPlus添加时，该方法会被调用
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("version", 1, metaObject);
        this.setFieldValByName("deleted", false, metaObject);
    }

    /**
     * 使用MybatisPlus修改时，该方法会被调用
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
