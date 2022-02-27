package ncepu.lykkk.exercise.service;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: spring-cloud-exercise
 * @description: swagger2服务类
 * @author: 林玉坤
 * @create: 2022-02-22 17:00
 **/
@Data
@AllArgsConstructor
public class Swagger2Service {

    private String base_package;

    private String title;

    private String description;

    private String name;

    private String url;

    private String email;

    private String version;

}
