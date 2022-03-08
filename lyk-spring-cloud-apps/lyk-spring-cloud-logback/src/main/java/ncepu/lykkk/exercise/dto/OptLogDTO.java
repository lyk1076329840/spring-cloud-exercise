package ncepu.lykkk.exercise.dto;

import lombok.Data;

/**
 * @program: spring-cloud-exercise
 * @description: 封装操作日志信息
 * @author: 林玉坤
 * @create: 2022-03-07 23:02
 **/
@Data
public class OptLogDTO {
    private String requestIp; //操作IP
    private String type; //日志类型 LogType{OPT:操作类型;EX:异常类型}
    private String userName; //操作人
    private String description; //操作描述
}
