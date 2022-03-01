package ncepu.lykkk.exercise.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @program: spring-cloud-exercise
 * @description: 用户类
 * @author: 林玉坤
 * @create: 2022-02-28 17:55
 **/
@Data
@ApiModel(value = "用户类")
public class User {

    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "id")
    private Integer id;

    @NotBlank(message = "用户名不能为空")
    @Length(max = 18, message = "用户名长度不能超过50")
    @ApiModelProperty(value = "用户名")
    private String username;

    @Max(value = 80,message = "年龄最大为80")
    @Min(value = 18,message = "年龄最小为18")
    @ApiModelProperty(value = "年龄")
    private int age;

    //    @Pattern(regexp = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "邮箱格式不正确")
    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "邮箱")
    private String email;

}
