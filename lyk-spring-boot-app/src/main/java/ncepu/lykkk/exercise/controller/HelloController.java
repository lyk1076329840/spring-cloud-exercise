package ncepu.lykkk.exercise.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ncepu.lykkk.exercise.log.MyLog;
import ncepu.lykkk.exercise.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: spring-cloud-exercise
 * @description: HelloController
 * @author: 林玉坤
 * @create: 2022-02-22 16:20
 **/
@RestController
@RequestMapping("/hello")
@Api(tags = "HelloController")
public class HelloController {

    //HelloService在我们自定义的starter中已经完成了自动配置，所以此处可以直接注入
    @Resource
    private HelloService helloService;

    @MyLog(desc = "sayHello方法") //日志记录注解
    @GetMapping("/say")
    @ApiOperation(value = "sayHello方法")
    public String sayHello(){
        return helloService.sayHello();
    }

}
