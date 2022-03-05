package ncepu.lykkk.exercise.annotation;

import java.lang.annotation.*;

/**
 * @program: spring-cloud-exercise
 * @description: 注解：当前用户
 * @author: 林玉坤
 * @create: 2022-03-05 15:18
 **/
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
