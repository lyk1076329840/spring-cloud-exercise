package ncepu.lykkk.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-exercise
 * @description: 用户控制类
 * @author: 林玉坤
 * @create: 2022-03-04 21:19
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    public String get(){
        //没有进行全局异常处理
        int i = 1 / 0;
        return "success";
    }

}
