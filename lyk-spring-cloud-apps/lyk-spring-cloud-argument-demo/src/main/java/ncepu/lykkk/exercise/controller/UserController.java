package ncepu.lykkk.exercise.controller;

import ncepu.lykkk.exercise.annotation.CurrentUser;
import ncepu.lykkk.exercise.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-exercise
 * @description: 用户控制类
 * @author: 林玉坤
 * @create: 2022-03-05 15:12
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    //获取当前系统登录用户
    @GetMapping("/getCurrentUser")
    public String getCurrentUser(@CurrentUser User user){
        String name = user.getUsername();
        System.out.println("UserController getCurrentUser方法");
        return user.toString();
    }


}
