package ncepu.lykkk.exercise.user.feign;

import lombok.*;

/**
 * @program: spring-cloud-exercise
 * @description: 用户查询对象
 * @author: 林玉坤
 * @create: 2022-03-05 15:59
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserQuery {

    /**
     * 是否查询SysUser对象所有信息，true则通过rpc接口查询
     */
    private Boolean full;

    /**
     * 是否只查询角色信息，true则通过rpc接口查询
     */
    private Boolean roles;

    /**
     * 是否只查询组织信息，true则通过rpc接口查询
     */
    private Boolean org;

    /**
     * 是否只查询岗位信息，true则通过rpc接口查询
     */
    private Boolean station;

}
