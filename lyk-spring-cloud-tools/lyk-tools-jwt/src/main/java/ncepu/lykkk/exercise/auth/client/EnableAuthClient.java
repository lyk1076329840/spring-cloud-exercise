package ncepu.lykkk.exercise.auth.client;

import ncepu.lykkk.exercise.auth.client.configuration.AuthClientConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @program: spring-cloud-exercise
 * @description: 启用授权Client
 * @author: 林玉坤
 * @create: 2022-02-28 22:53
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({AuthClientConfiguration.class})
@Documented
@Inherited
public @interface EnableAuthClient {
}
