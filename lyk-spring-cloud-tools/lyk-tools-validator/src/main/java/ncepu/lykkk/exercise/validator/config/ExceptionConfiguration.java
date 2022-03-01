package ncepu.lykkk.exercise.validator.config;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Objects;


/**
 * @program: spring-cloud-exercise
 * @description: 全局异常类处理
 * @author: 林玉坤
 * @create: 2022-02-28 17:20
 **/
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
public class ExceptionConfiguration {

    /**
     * 异常处理方法
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler({ConstraintViolationException.class, BindException.class})
    public String exceptionHandler(Exception exception, HttpServletRequest request){
        String msg = "";
        if(exception instanceof ConstraintViolationException){
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) exception;
//            System.out.println(constraintViolationException.getMessage());
            ConstraintViolation<?> next = constraintViolationException.getConstraintViolations().iterator().next();
            msg = next.getMessage();
        }
        else if(exception instanceof BindException){
            BindException bindException = (BindException) exception;
//            List<ObjectError> errors = bindException.getAllErrors();
//            for(ObjectError error: errors){
//                msg += error.getDefaultMessage() + '\n';
//            }
            msg = Objects.requireNonNull(bindException.getBindingResult().getFieldError()).getDefaultMessage();
//            msg = bindException.getMessage();
//            System.out.println("msg=" + msg);
        }
        return msg;
    }

}
