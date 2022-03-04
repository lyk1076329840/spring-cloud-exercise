package ncepu.lykkk.exercise.auth.client.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static ncepu.lykkk.exercise.auth.client.properties.AuthClientProperties.PREFIX;

/**
 * @program: spring-cloud-exercise
 * @description: 客户端认证配置
 * @author: 林玉坤
 * @create: 2022-03-04 10:57
 **/
@ConfigurationProperties(prefix = PREFIX)
@Data
@NoArgsConstructor
public class AuthClientProperties {
    public static final String PREFIX = "authentication";
    private TokenInfo user;
    @Data
    public static class TokenInfo {
        /**
         * 请求头名称
         */
        private String headerName;
        /**
         * 解密 网关使用
         */
        private String pubKey;
    }
}
