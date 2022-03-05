package ncepu.lykkk.exercise.user.model;

import lombok.*;

/**
 * @program: spring-cloud-exercise
 * @description:
 * @author: 林玉坤
 * @create: 2022-03-05 15:53
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class SysOrg {

    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 简称
     */
    private String abbreviation;

    /**
     * 父ID
     */
    private Long parentId;

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
