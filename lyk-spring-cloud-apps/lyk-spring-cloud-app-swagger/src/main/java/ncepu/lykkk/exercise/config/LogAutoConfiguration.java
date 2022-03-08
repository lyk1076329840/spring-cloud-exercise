package ncepu.lykkk.exercise.config;

import ncepu.lykkk.exercise.log.event.SysLogListener;
import ncepu.lykkk.exercise.service.LogService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-cloud-exercise
 * @description: 日志配置类
 * @author: 林玉坤
 * @create: 2022-03-08 11:30
 **/
@Configuration
public class LogAutoConfiguration {
    //自动配置日志监听器组件
    @Bean
    @ConditionalOnMissingBean
    public SysLogListener sysLogListener(LogService logService){
        return new SysLogListener(optLogDTO -> logService.saveLog(optLogDTO));
    }
}
