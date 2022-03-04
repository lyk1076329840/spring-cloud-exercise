package ncepu.lykkk.exercise.exception;

/**
 * @program: spring-cloud-exercise
 * @description: 异常接口类
 * @author: 林玉坤
 * @create: 2022-03-01 23:24
 **/
public interface BaseException {

    /**
     * 统一参数验证异常码
     */
    int BASE_VALID_PARAM = -9;

    /**
     * 返回异常信息
     *
     * @return
     */
    String getMessage();

    /**
     * 返回异常编码
     *
     * @return
     */
    int getCode();

}
