package ncepu.lykkk.exercise;

import ncepu.lykkk.exercise.user.annotation.EnableLoginArgResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: spring-cloud-exercise
 * @description: 用户启动类
 * @author: 林玉坤
 * @create: 2022-03-05 16:50
 **/
@SpringBootApplication
@EnableLoginArgResolver
public class LykSpringCloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(LykSpringCloudUserApplication.class,args);
    }
}
