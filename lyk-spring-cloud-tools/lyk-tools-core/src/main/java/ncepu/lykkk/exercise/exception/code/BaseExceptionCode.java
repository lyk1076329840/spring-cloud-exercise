package ncepu.lykkk.exercise.exception.code;

/**
 * @program: spring-cloud-exercise
 * @description:
 * @author: 林玉坤
 * @create: 2022-03-01 23:27
 **/
public interface BaseExceptionCode {

    /**
     * 异常编码
     *
     * @return
     */
    int getCode();

    /**
     * 异常消息
     * @return
     */
    String getMsg();

}
