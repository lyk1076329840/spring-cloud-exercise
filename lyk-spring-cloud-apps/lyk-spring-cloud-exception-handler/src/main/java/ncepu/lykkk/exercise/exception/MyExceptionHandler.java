package ncepu.lykkk.exercise.exception;

import ncepu.lykkk.exercise.handler.DefaultGlobalExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: spring-cloud-exercise
 * @description: 全局异常处理器
 * @author: 林玉坤
 * @create: 2022-03-04 22:22
 **/
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler extends DefaultGlobalExceptionHandler {

    //异常处理方法，当系统发生异常时，执行此方法
    //Exception是个父类 其包含的子类特别多
    //在项目中需要区分不同异常
//    @ExceptionHandler(Exception.class)
//    public String exceptionHandler(Exception ex){
//        ex.printStackTrace();
//        return "系统异常";
//    }



}
