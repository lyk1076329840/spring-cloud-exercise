package ncepu.lykkk.exercise.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: spring-cloud-exercise
 * @description: 读取配置文件转换为Bean
 * @author: 林玉坤
 * @create: 2022-02-22 15:50
 **/
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "HelloProperties{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
