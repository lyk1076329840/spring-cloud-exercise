package ncepu.lykkk.exercise;

import com.github.dozermapper.core.Mapper;
import ncepu.lykkk.exercise.dto.UserDTO;
import ncepu.lykkk.exercise.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: spring-cloud-exercise
 * @description: dozer 测试类
 * @author: 林玉坤
 * @create: 2022-03-04 19:45
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LykSpringCloudDozerDemoApplication.class)
public class DozerTest {

    @Resource
    private Mapper mapper;

    @Test
    public void testDozer1(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId("100");
        userDTO.setUserName("itcast");
        userDTO.setUserAge(20);
        userDTO.setAddress("bj");
        userDTO.setBirthday("2010-11-20");

        UserEntity user = mapper.map(userDTO, UserEntity.class);
        System.out.println(user);
    }

    @Test
    public void testDozer2(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId("100");
        userDTO.setUserName("itcast");
        userDTO.setUserAge(20);
        userDTO.setAddress("bj");
        userDTO.setBirthday("2010-11-20");

        UserEntity user = new UserEntity();
        user.setId("200");
        System.out.println(user);
        mapper.map(userDTO,user);
        System.out.println(user);
    }

    @Test
    public void testDozer3(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId("100");
        userDTO.setUserName("itcast");
        userDTO.setUserAge(20);
        userDTO.setAddress("bj");

        UserEntity user = new UserEntity();
        System.out.println(user);
        mapper.map(userDTO,user,"user");
        System.out.println(user);
    }




}
