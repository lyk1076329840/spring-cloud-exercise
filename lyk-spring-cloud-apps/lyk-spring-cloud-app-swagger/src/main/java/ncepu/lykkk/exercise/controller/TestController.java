package ncepu.lykkk.exercise.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-exercise
 * @description: 测试类
 * @author: 林玉坤
 * @create: 2022-02-26 22:25
 **/
@RestController
@RequestMapping("/test")
@Api(tags = "TestController")
public class TestController {

    @GetMapping("/say")
    @ApiOperation(value = "sayHello方法")
    public String sayHello(){
        return "Hello World!";
    }

}
