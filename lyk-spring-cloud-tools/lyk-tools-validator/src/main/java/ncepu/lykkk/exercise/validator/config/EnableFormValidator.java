package ncepu.lykkk.exercise.validator.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: spring-cloud-exercise
 * @description: 在启动类上添加该注解来启动表单验证功能——快速失败返回模式
 * @author: 林玉坤
 * @create: 2022-02-28 17:26
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ValidatorConfiguration.class)
public @interface EnableFormValidator {
}
