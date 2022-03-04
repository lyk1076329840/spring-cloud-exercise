package ncepu.lykkk.exercise.auth.client.configuration;

import ncepu.lykkk.exercise.auth.client.properties.AuthClientProperties;
import ncepu.lykkk.exercise.auth.client.utils.JwtTokenClientUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @program: spring-cloud-exercise
 * @description: 客户端认证配置
 * @author: 林玉坤
 * @create: 2022-03-04 10:58
 **/
@EnableConfigurationProperties(value = {
        AuthClientProperties.class,
})
public class AuthClientConfiguration {
    @Bean
    public JwtTokenClientUtils getJwtTokenClientUtils(AuthClientProperties authClientProperties) {
        return new JwtTokenClientUtils(authClientProperties);
    }

}
