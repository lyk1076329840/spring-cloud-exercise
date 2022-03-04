package ncepu.lykkk.exercise.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ncepu.lykkk.exercise.base.BaseEnum;

/**
 * @program: spring-cloud-exercise
 * @description:
 * @author: 林玉坤
 * @create: 2022-03-03 17:19
 **/
@ApiModel(value = "HttpMethod", description = "HTTP方法-枚举")
@AllArgsConstructor
@NoArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum HttpMethod implements BaseEnum {
    /**
     * GET:GET
     */
    GET("GET"),
    /**
     * POST:POST
     */
    POST("POST"),
    /**
     * PUT:PUT
     */
    PUT("PUT"),
    /**
     * DELETE:DELETE
     */
    DELETE("DELETE"),
    /**
     * PATCH:PATCH
     */
    PATCH("PATCH"),
    /**
     * TRACE:TRACE
     */
    TRACE("TRACE"),
    /**
     * HEAD:HEAD
     */
    HEAD("HEAD"),
    /**
     * OPTIONS:OPTIONS
     */
    OPTIONS("OPTIONS"),
    ;
    @ApiModelProperty(value = "描述")
    private String desc;

    public static HttpMethod match(String val, HttpMethod def) {
        for (HttpMethod enm : HttpMethod.values()) {
            if (enm.name().equalsIgnoreCase(val)) {
                return enm;
            }
        }
        return def;
    }

    public static HttpMethod get(String val) {
        return match(val, null);
    }

    public boolean eq(String val) {
        return this.name().equalsIgnoreCase(val);
    }

    public boolean eq(HttpMethod val) {
        if (val == null) {
            return false;
        }
        return eq(val.name());
    }

    @Override
    @ApiModelProperty(value = "编码", allowableValues = "GET,POST,PUT,DELETE,PATCH,TRACE,HEAD,OPTIONS", example = "GET")
    public String getCode() {
        return this.name();
    }

    /**
     * 这是源代码中没有的
     * @return
     */
    @Override
    public String getDesc() {
        return null;
    }


}