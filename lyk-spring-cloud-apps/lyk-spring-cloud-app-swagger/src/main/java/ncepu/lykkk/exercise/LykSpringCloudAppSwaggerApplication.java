package ncepu.lykkk.exercise;

import ncepu.lykkk.exercise.validator.config.EnableFormValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * @program: spring-cloud-exercise
 * @description: springboot启动类
 * @author: 林玉坤
 * @create: 2022-02-26 22:12
 **/
@SpringBootApplication
@EnableFormValidator
public class LykSpringCloudAppSwaggerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LykSpringCloudAppSwaggerApplication.class,args);
    }
}
