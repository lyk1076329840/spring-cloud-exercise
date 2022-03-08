package ncepu.lykkk.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @program: spring-cloud-exercise
 * @description: logback 启动类
 * @author: 林玉坤
 * @create: 2022-03-07 20:31
 **/
@SpringBootApplication
@EnableAsync
public class LykSpringCloudLogbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LykSpringCloudLogbackApplication.class,args);
    }

}
