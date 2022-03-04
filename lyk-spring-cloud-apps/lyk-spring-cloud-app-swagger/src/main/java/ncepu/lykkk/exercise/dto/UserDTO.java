package ncepu.lykkk.exercise.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: spring-cloud-exercise
 * @description: 用户传输类
 * @author: 林玉坤
 * @create: 2022-03-04 20:22
 **/
@Data
public class UserDTO {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private int age;

    @ApiModelProperty(value = "地址")
    private String addr;

}
