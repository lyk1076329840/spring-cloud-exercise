package ncepu.lykkk.exercise.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ncepu.lykkk.exercise.user.annotation.LoginUser;
import ncepu.lykkk.exercise.user.model.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-exercise
 * @description: 用户Controller
 * @author: 林玉坤
 * @create: 2022-03-05 16:51
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "UserController")
public class UserController {

    @GetMapping("/get")
    @ApiOperation(value = "获取当前用户")
    public SysUser getCurrentUser(@LoginUser SysUser user){
        System.out.println(user);
        return user;
    }

}
