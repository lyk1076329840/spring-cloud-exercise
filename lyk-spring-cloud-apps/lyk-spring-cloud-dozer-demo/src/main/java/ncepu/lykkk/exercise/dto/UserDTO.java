package ncepu.lykkk.exercise.dto;

import lombok.Data;

/**
 * @program: spring-cloud-exercise
 * @description: User数据传输对象
 * @author: 林玉坤
 * @create: 2022-03-04 19:27
 **/
@Data
public class UserDTO {
    private String userId;
    private String userName;
    private int userAge;
    private String address;
    private String birthday;
}
