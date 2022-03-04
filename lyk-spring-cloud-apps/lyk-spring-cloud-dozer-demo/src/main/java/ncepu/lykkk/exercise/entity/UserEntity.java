package ncepu.lykkk.exercise.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: spring-cloud-exercise
 * @description: User实体类对象
 * @author: 林玉坤
 * @create: 2022-03-04 19:28
 **/
@Data
public class UserEntity {
    private String id;
    private String name;
    private int age;
    private String address;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
