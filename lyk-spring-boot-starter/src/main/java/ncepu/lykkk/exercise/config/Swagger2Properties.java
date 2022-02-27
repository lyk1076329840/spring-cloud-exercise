package ncepu.lykkk.exercise.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: spring-cloud-exercise
 * @description: Swagger2相关参数
 * @author: 林玉坤
 * @create: 2022-02-22 16:53
 **/
@Data
@ConfigurationProperties(prefix = "lyk.swagger2")
public class Swagger2Properties {

    private String base_package;

    private String title;

    private String description;

    private String name;

    private String url;

    private String email;

    private String version;

}
