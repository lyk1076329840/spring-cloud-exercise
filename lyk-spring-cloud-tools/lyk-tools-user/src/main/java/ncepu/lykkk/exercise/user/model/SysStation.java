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
public class SysStation {

    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 组织ID
     * #pd_core_org
     */
    private Long orgId;

    /**
     * 排序
     */
    private Integer sortValue;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 描述
     */
    private String describe;

}
