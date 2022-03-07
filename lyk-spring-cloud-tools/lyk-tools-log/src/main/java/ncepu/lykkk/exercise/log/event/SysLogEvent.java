package ncepu.lykkk.exercise.log.event;

import ncepu.lykkk.exercise.log.entity.OptLogDTO;
import org.springframework.context.ApplicationEvent;

/**
 * @program: spring-cloud-exercise
 * @description: 系统日志事件
 * @author: 林玉坤
 * @create: 2022-03-07 16:37
 **/
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(OptLogDTO source) {
        super(source);
    }
}
