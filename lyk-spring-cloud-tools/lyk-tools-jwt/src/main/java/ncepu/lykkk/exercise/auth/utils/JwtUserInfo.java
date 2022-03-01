package ncepu.lykkk.exercise.auth.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: spring-cloud-exercise
 * @description: jwt 存储的 内容
 * @author: 林玉坤
 * @create: 2022-03-01 11:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUserInfo {

    /**
     * 账号id
     */
    private Long userId;
    /**
     * 账号
     */
    private String account;
    /**
     * 姓名
     */
    private String name;

    /**
     * 当前登录人单位id
     */
    private Long orgId;

    /**
     * 当前登录人岗位ID
     */
    private Long stationId;

}
