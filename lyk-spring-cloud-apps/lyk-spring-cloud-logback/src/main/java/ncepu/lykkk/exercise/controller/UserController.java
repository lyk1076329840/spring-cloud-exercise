package ncepu.lykkk.exercise.controller;

import ncepu.lykkk.exercise.dto.OptLogDTO;
import ncepu.lykkk.exercise.event.SysLogEvent;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: spring-cloud-exercise
 * @description: 用户控制类
 * @author: 林玉坤
 * @create: 2022-03-07 22:46
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    //UserController.class -> ncepu.lykkk.exercise.controller.UserController
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/get")
    public String get(){
        logger.trace("trace...");
        logger.debug("debug...");
        logger.info("info...");
        logger.warn("warn...");
        logger.error("error...");

        return "ok";
    }

    @GetMapping("/getUser")
    public String getUser(){

        //构造日志信息
        OptLogDTO logInfo = new OptLogDTO();
        logInfo.setRequestIp("127.0.0.1");
        logInfo.setUserName("admin");
        logInfo.setType("OPT");
        logInfo.setDescription("查询用户信息");

        //构造事件对象
        ApplicationEvent event = new SysLogEvent(logInfo);

        //发布日志事件
        applicationEventPublisher.publishEvent(event);

        long id = Thread.currentThread().getId();
        System.out.println("发布事件,线程id：" + id);

        return "ok";

    }

}
