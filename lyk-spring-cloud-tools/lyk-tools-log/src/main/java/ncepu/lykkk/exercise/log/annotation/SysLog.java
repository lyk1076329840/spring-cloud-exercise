package ncepu.lykkk.exercise.log.annotation;

import java.lang.annotation.*;

/**
 * @program: spring-cloud-exercise
 * @description: 操作日志注解
 * @author: 林玉坤
 * @create: 2022-03-07 16:35
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    /**
     * 描述
     *
     * @return {String}
     */
    String value();

    /**
     * 记录执行参数
     *
     * @return
     */
    boolean recordRequestParam() default true;

    /**
     * 记录返回参数
     *
     * @return
     */
    boolean recordResponseParam() default true;
}
