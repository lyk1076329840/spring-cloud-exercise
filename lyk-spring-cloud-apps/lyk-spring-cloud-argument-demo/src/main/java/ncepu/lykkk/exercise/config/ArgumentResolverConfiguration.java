package ncepu.lykkk.exercise.config;

import ncepu.lykkk.exercise.resolver.CurrentUserMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @program: spring-cloud-exercise
 * @description: 参数解析器自动配置类
 * @author: 林玉坤
 * @create: 2022-03-05 15:30
 **/
@Configuration
public class ArgumentResolverConfiguration implements WebMvcConfigurer {

    public CurrentUserMethodArgumentResolver getCurrentUserMethodArgumentResolver(){
        return new CurrentUserMethodArgumentResolver();
    }


    //注册自定义参数解析器
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(getCurrentUserMethodArgumentResolver());
    }

}
