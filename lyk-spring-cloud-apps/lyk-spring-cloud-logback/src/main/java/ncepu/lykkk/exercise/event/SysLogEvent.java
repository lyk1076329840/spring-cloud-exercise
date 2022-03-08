package ncepu.lykkk.exercise.event;

import ncepu.lykkk.exercise.dto.OptLogDTO;
import org.springframework.context.ApplicationEvent;

/**
 * @program: spring-cloud-exercise
 * @description: 定义系统日志事件
 * @author: 林玉坤
 * @create: 2022-03-07 23:04
 **/
public class SysLogEvent extends ApplicationEvent {
    public SysLogEvent(OptLogDTO optLogDTO) {
        super(optLogDTO);
    }
}
