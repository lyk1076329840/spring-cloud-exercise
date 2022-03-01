package ncepu.lykkk.exercise.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ncepu.lykkk.exercise.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @program: spring-cloud-exercise
 * @description: 用户控制类
 * @author: 林玉坤
 * @create: 2022-02-28 15:07
 **/
@RestController
@RequestMapping("/user")
@Validated //开启hibernator-validaor 类型校验
@Api(tags = "UserController")
public class UserController {

    /**
     * 简单类型的校验
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除操作")
    public String delete(@NotNull(message = "id不能为空") Integer id){
        return "delete success";
    }

    /**
     * 对象类型的校验
     * @param user
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "保存操作")
    public String save(@Validated User user){
        return "save success";
    }

}
