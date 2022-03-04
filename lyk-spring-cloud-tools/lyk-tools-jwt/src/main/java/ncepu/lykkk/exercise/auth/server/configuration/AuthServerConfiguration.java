package ncepu.lykkk.exercise.auth.server.configuration;

import ncepu.lykkk.exercise.auth.server.properties.AuthServerProperties;
import ncepu.lykkk.exercise.auth.server.utils.JwtTokenServerUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @program: spring-cloud-exercise
 * @description: 认证服务端配置
 * @author: 林玉坤
 * @create: 2022-03-04 10:40
 **/
@EnableConfigurationProperties(value = {
        AuthServerProperties.class,
})
public class AuthServerConfiguration {

    @Bean
    public JwtTokenServerUtils getJwtTokenServerUtils(AuthServerProperties authServerProperties) {
        return new JwtTokenServerUtils(authServerProperties);
    }

}
