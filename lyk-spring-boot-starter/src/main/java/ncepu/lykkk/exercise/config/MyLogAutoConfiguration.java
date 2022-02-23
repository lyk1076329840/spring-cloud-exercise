package ncepu.lykkk.exercise.config;

import ncepu.lykkk.exercise.log.MyLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: spring-cloud-exercise
 * @description: 创建自动配置类MyLogAutoConfiguration，用于自动配置拦截器、参数解析器等web组件
 * @author: 林玉坤
 * @create: 2022-02-22 16:41
 **/
@Configuration
public class MyLogAutoConfiguration implements WebMvcConfigurer {

    //注册自定义日志拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyLogInterceptor());
    }

}
