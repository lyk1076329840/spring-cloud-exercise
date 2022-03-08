package ncepu.lykkk.exercise.service;

import lombok.extern.slf4j.Slf4j;
import ncepu.lykkk.exercise.log.entity.OptLogDTO;
import org.springframework.stereotype.Service;

/**
 * @program: spring-cloud-exercise
 * @description: 日志保存服务
 * @author: 林玉坤
 * @create: 2022-03-08 11:28
 **/
@Service
@Slf4j
public class LogService {



    //将日志信息保存到数据库
    public void saveLog(OptLogDTO optLogDTO){
        //此处只是将日志信息进行输出，实际项目中可以将日志信息保存到数据库
        System.out.println("保存日志信息：" + optLogDTO.toString());
    }
}
