package ncepu.lykkk.exercise.resolver;

import ncepu.lykkk.exercise.annotation.CurrentUser;
import ncepu.lykkk.exercise.entity.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @program: spring-cloud-exercise
 * @description: 自定义参数解析器
 * 动态为controller方法注入当前登录用户对象
 * @author: 林玉坤
 * @create: 2022-03-05 15:21
 **/
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //动态判断 当前controller方法中参数类型、是否加入了CurrentUser注解
        //parameter封装了整个controller当中的方法
        if(parameter.getParameterType().equals(User.class) && parameter.hasParameterAnnotation(CurrentUser.class))
            return true;
        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //动态获取当前登录用户信息

        //此处模拟用户
        User user = new User(1L,"admin");

        return user;
    }
}
