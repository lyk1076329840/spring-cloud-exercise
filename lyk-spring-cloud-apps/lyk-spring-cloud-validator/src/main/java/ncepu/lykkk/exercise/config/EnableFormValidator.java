package ncepu.lykkk.exercise.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: spring-cloud-exercise
 * @description: 在启动类上添加改注解来启动表单验证功能——快速失败返回模式
 * @author: 林玉坤
 * @create: 2022-02-28 16:50
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ValidatorConfiguration.class)
public @interface EnableFormValidator {
}
