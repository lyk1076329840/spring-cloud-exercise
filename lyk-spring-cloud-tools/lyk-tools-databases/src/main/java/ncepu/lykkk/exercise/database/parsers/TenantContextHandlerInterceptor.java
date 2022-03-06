package ncepu.lykkk.exercise.database.parsers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ncepu.lykkk.exercise.context.BaseContextHandler;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: spring-cloud-exercise
 * @description:
 * @author: 林玉坤
 * @create: 2022-03-05 17:41
 **/
@Slf4j
@AllArgsConstructor
public class TenantContextHandlerInterceptor extends HandlerInterceptorAdapter {

    private String databaseName;

    /**
     * 在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制等处理；
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            log.info("not exec!!! url={}", request.getRequestURL());
            return super.preHandle(request, response, handler);
        }
        BaseContextHandler.setDatabase(this.databaseName);
        return super.preHandle(request, response, handler);
    }

    /**
     * 在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。
     * 返回处理（已经渲染了页面），可以根据ex是否为null判断是否发生了异常，进行日志记录；
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContextHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }

}
