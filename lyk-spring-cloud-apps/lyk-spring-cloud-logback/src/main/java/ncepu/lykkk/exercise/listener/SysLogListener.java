package ncepu.lykkk.exercise.listener;

import ncepu.lykkk.exercise.dto.OptLogDTO;
import ncepu.lykkk.exercise.event.SysLogEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-exercise
 * @description: 异步监听日志事件
 * @author: 林玉坤
 * @create: 2022-03-07 23:06
 **/
@Component
public class SysLogListener {
    @Async//异步处理
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        OptLogDTO sysLog = (OptLogDTO) event.getSource();
        long id = Thread.currentThread().getId();
        System.out.println("监听到日志操作事件：" + sysLog + " 线程id：" + id);
        //将日志信息保存到数据库...
    }
}
