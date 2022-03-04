package ncepu.lykkk.exercise.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * @program: spring-cloud-exercise
 * @description: Spring 工具类
 * @author: 林玉坤
 * @create: 2022-03-03 15:39
 **/
@SuppressWarnings("squid:S1166")
public class SpringUtils {

    private static ApplicationContext applicationContext;
    private static ApplicationContext parentApplicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext ctx) {
        Assert.notNull(ctx, "SpringUtil injection ApplicationContext is null");
        applicationContext = ctx;
        parentApplicationContext = ctx.getParent();
    }

    public static Object getBean(String name) {
        Assert.hasText(name, "SpringUtil name is null or empty");
        try {
            return applicationContext.getBean(name);
        } catch (Exception e) {
            return parentApplicationContext.getBean(name);
        }
    }

    public static <T> T getBean(String name, Class<T> type) {
        Assert.hasText(name, "SpringUtil name is null or empty");
        Assert.notNull(type, "SpringUtil type is null");
        try {
            return applicationContext.getBean(name, type);
        } catch (Exception e) {
            return parentApplicationContext.getBean(name, type);
        }
    }

    public static <T> T getBean(Class<T> type) {
        Assert.notNull(type, "SpringUtil type is null");
        try {
            return applicationContext.getBean(type);
        } catch (Exception e) {
            return parentApplicationContext.getBean(type);
        }
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        Assert.notNull(type, "SpringUtil type is null");
        try {
            return applicationContext.getBeansOfType(type);
        } catch (Exception e) {
            return parentApplicationContext.getBeansOfType(type);
        }
    }

}
