package ncepu.lykkk.exercise.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: spring-cloud-exercise
 * @description: 用户实体类
 * @author: 林玉坤
 * @create: 2022-03-04 20:21
 **/
@Data
@ApiModel(value = "用户实体类")
public class UserEntity {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private int age;

    @ApiModelProperty(value = "地址")
    private String address;

}
