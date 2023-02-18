package cn.geekhall.hera.server;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * ServerApplication
 *
 * @author yiny
 */
//@EnableOpenApi
@SpringBootApplication
@ComponentScan(basePackages = {"cn.geekhall.hera"})
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
