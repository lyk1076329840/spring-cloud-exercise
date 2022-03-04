package ncepu.lykkk.exercise.auth.server;

import ncepu.lykkk.exercise.auth.server.configuration.AuthServerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @program: spring-cloud-exercise
 * @description: 启用授权Server
 * @author: 林玉坤
 * @create: 2022-02-28 23:03
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AuthServerConfiguration.class)
@Documented
@Inherited
public @interface EnableAuthServer {
}
