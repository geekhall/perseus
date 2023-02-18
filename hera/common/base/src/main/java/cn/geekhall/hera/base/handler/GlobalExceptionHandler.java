package cn.geekhall.hera.base.handler;

import cn.geekhall.hera.base.exception.HeraException;
import cn.geekhall.hera.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ExceptionHandler
 *
 * @author yiny
 * @date 2022/3/28 06:20
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 全局异常处理
     * @param e Exception
     * @return 返回信息
     */
    @ExceptionHandler(Exception.class) // 指定出现什么异常执行该方法
    @ResponseBody
    public Result error(Exception e){
        logger.error(e.getMessage());
        e.printStackTrace();
        return Result.error().message("全局异常");
    }

    /**
     * 特定异常处理
     * @param e Exception
     * @return 返回信息
     */
    @ExceptionHandler(ArithmeticException.class) // 指定出现什么异常执行该方法
    @ResponseBody
    public Result error(ArithmeticException e){
        logger.error(e.getMessage());
        e.printStackTrace();
        return Result.error().message("算术异常");
    }

    /**
     * 自定义异常处理
     * @param e Exception
     * @return 返回信息
     */
    @ExceptionHandler(HeraException.class) // 指定出现什么异常执行该方法
    @ResponseBody
    public Result error(HeraException e){
        logger.error(e.getMessage());
        e.printStackTrace();
        return Result.error().code(e.getCode()).message(e.getMessage());
    }
}
