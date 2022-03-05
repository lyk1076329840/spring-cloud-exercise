package ncepu.lykkk.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-cloud-exercise
 * @description: 用户对象
 * @author: 林玉坤
 * @create: 2022-03-05 11:46
 **/
@Data
@AllArgsConstructor
public class User implements Serializable {

    private Long id;

    private String username;

}
