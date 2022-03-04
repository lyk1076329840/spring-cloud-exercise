package ncepu.lykkk.exercise.auth.server.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static ncepu.lykkk.exercise.auth.server.properties.AuthServerProperties.PREFIX;

/**
 * @program: spring-cloud-exercise
 * @description: 认证服务端属性
 * @author: 林玉坤
 * @create: 2022-03-04 10:38
 **/
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = PREFIX)
public class AuthServerProperties {

    public static final String PREFIX = "authentication";

    private TokenInfo user;

    @Data
    public static class TokenInfo {
        /**
         * 过期时间
         */
        private Integer expire = 7200;
        /**
         * 加密 服务使用
         */
        private String priKey;
        /**
         * 解密
         */
        private String pubKey;
    }

}
