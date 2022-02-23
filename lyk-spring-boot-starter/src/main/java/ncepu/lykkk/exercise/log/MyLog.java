package ncepu.lykkk.exercise.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: spring-cloud-exercise
 * @description: 自定义MyLog注解
 * @author: 林玉坤
 * @create: 2022-02-22 16:36
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    /**
     * 方法描述
     */
    String desc() default "";

}
