package ncepu.lykkk.exercise.auth.client.utils;

import lombok.AllArgsConstructor;
import ncepu.lykkk.exercise.auth.client.properties.AuthClientProperties;
import ncepu.lykkk.exercise.auth.utils.JwtHelper;
import ncepu.lykkk.exercise.auth.utils.JwtUserInfo;
import ncepu.lykkk.exercise.exception.BizException;

/**
 * @program: spring-cloud-exercise
 * @description: jwt 客户端工具
 * @author: 林玉坤
 * @create: 2022-03-04 10:57
 **/
@AllArgsConstructor
public class JwtTokenClientUtils {

    /**
     * 用于 认证服务的 客户端使用（如 网关） ， 在网关获取到token后，
     * 调用此工具类进行token 解析。
     * 客户端一般只需要解析token 即可
     */
    private AuthClientProperties authClientProperties;

    /**
     * 解析token
     *
     * @param token
     * @return
     * @throws BizException
     */
    public JwtUserInfo getUserInfo(String token) throws BizException {
        AuthClientProperties.TokenInfo userTokenInfo = authClientProperties.getUser();
        return JwtHelper.getJwtFromToken(token, userTokenInfo.getPubKey());
    }

}
