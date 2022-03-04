package ncepu.lykkk.exercise.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ncepu.lykkk.exercise.dozer.DozerUtils;
import ncepu.lykkk.exercise.dto.UserDTO;
import ncepu.lykkk.exercise.entity.User;
import ncepu.lykkk.exercise.entity.UserEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @program: spring-cloud-exercise
 * @description: 用户控制类
 * @author: 林玉坤
 * @create: 2022-02-28 17:56
 **/
@RestController
@RequestMapping("/user")
@Validated //开启hibernator-validaor 类型校验
@Api(tags = "UserController")
public class UserController {

    @Resource
    private DozerUtils dozerUtils;

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


    @GetMapping("/mapper1")
    @ApiOperation(value = "dozer操作")
    public UserEntity mapper1(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(10);
        userDTO.setName("lykkk");
        userDTO.setAge(18);
        userDTO.setAddr("北京");

        UserEntity userEntity = dozerUtils.map(userDTO,UserEntity.class);
        return userEntity;
    }


}
