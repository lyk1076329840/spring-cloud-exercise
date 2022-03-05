package ncepu.lykkk.exercise.user.annotation;

import ncepu.lykkk.exercise.user.config.LoginArgResolverConfig;
import ncepu.lykkk.exercise.user.feign.UserResolveApi;
import ncepu.lykkk.exercise.user.interceptor.ContextHandlerInterceptor;
import ncepu.lykkk.exercise.user.resolver.ContextArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * @program: spring-cloud-exercise
 * @description: 在启动类上添加该注解来----开启自动登录用户对象注入
 * Token转化SysUser
 * @author: 林玉坤
 * @create: 2022-03-05 15:45
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LoginArgResolverConfig.class)
public @interface EnableLoginArgResolver {
}
