package ncepu.lykkk.exercise.log.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ncepu.lykkk.exercise.log.entity.OptLogDTO;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.util.function.Consumer;

/**
 * @program: spring-cloud-exercise
 * @description: 异步监听日志事件
 * @author: 林玉坤
 * @create: 2022-03-07 16:38
 **/
@Slf4j
@AllArgsConstructor
public class SysLogListener {
    //private String database;
    private Consumer<OptLogDTO> consumer;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        OptLogDTO optLog = (OptLogDTO) event.getSource();
        //BaseContextHandler.setDatabase(database);
        // 这里可以储存到数据库中，但是由于不同的系统对于操作日志的处理方式是不同的 所以为了实现通用日志功能 仅实现了日志的收集
        consumer.accept(optLog);
    }
}
