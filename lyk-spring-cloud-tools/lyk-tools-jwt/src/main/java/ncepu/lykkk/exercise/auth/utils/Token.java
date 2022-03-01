package ncepu.lykkk.exercise.auth.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: spring-cloud-exercise
 * @description: token类
 * @author: 林玉坤
 * @create: 2022-03-01 11:33
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable {

    private static final long serialVersionUID = -8482946147572784305L;
    /**
     * token
     */
    @ApiModelProperty(value = "token")
    private String token;
    /**
     * 有效时间：单位：秒
     */
    @ApiModelProperty(value = "有效期")
    private Integer expire;

}
