package ncepu.lykkk.exercise.log;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @program: spring-cloud-exercise
 * @description: 自定义日志拦截器MyLogInterceptor
 * @author: 林玉坤
 * @create: 2022-02-22 16:37
 **/
@Component
public class MyLogInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();//获得被拦截的方法对象
            MyLog myLog = method.getAnnotation(MyLog.class);//获得方法上的注解
            if(myLog != null){
                //方法上加了MyLog注解，需要进行日志记录
                long startTime = System.currentTimeMillis();
                startTimeThreadLocal.set(startTime);
            }
//            return true;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();//获得被拦截的方法对象
            MyLog myLog = method.getAnnotation(MyLog.class);//获得方法上的注解
            if(myLog != null){
                //方法上加了MyLog注解，需要进行日志记录
                long endTime = System.currentTimeMillis();
                Long startTime = startTimeThreadLocal.get();
                long optTime = endTime - startTime;

                String requestUri = request.getRequestURI();
                String methodName = method.getDeclaringClass().getName() + "." +
                        method.getName();
                String methodDesc = myLog.desc();

                System.out.println("请求uri：" + requestUri);
                System.out.println("请求方法名：" + methodName);
                System.out.println("方法描述：" + methodDesc);
                System.out.println("方法执行时间：" + optTime + "ms");
            }
        }

    }

}
