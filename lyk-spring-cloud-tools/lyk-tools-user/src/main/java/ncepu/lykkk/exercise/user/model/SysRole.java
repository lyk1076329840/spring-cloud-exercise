package ncepu.lykkk.exercise.user.model;

import lombok.*;

/**
 * @program: spring-cloud-exercise
 * @description:
 * @author: 林玉坤
 * @create: 2022-03-05 15:54
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class SysRole {

    private static final long serialVersionUID = 1L;
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 功能描述
     */
    private String describe;

    /**
     * 是否启用
     */
    private Boolean isEnable;

    /**
     * 是否只读角色
     */
    private Boolean isReadonly;

}
