package ncepu.lykkk.exercise.service;

/**
 * @program: spring-cloud-exercise
 * @description: HelloService类
 * @author: 林玉坤
 * @create: 2022-02-22 15:51
 **/
public class HelloService {
    private String name;
    private String address;

    public HelloService(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String sayHello(){
        return "你好！我的名字叫 " + name + "，我来自 " + address;
    }
}
