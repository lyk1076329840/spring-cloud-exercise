package ncepu.lykkk.exercise.auth.server.utils;

import lombok.AllArgsConstructor;
import ncepu.lykkk.exercise.auth.server.properties.AuthServerProperties;
import ncepu.lykkk.exercise.auth.utils.JwtHelper;
import ncepu.lykkk.exercise.auth.utils.JwtUserInfo;
import ncepu.lykkk.exercise.auth.utils.Token;
import ncepu.lykkk.exercise.exception.BizException;

/**
 * @program: spring-cloud-exercise
 * @description: jwt token 工具类
 * @author: 林玉坤
 * @create: 2022-03-04 10:36
 **/
@AllArgsConstructor
public class JwtTokenServerUtils {

    /**
     * 认证服务端使用，如 authority-server
     * 生成和 解析token
     */
    private AuthServerProperties authServerProperties;

    /**
     * 生成token
     * @param jwtInfo
     * @param expire
     * @return
     * @throws BizException
     */
    public Token generateUserToken(JwtUserInfo jwtInfo, Integer expire) throws BizException {
        AuthServerProperties.TokenInfo userTokenInfo = authServerProperties.getUser();
        if (expire == null || expire <= 0) {
            expire = userTokenInfo.getExpire();
        }
        return JwtHelper.generateUserToken(jwtInfo, userTokenInfo.getPriKey(), expire);
    }

    /**
     * 解析token
     * @param token
     * @return
     * @throws BizException
     */
    public JwtUserInfo getUserInfo(String token) throws BizException {
        AuthServerProperties.TokenInfo userTokenInfo = authServerProperties.getUser();
        return JwtHelper.getJwtFromToken(token, userTokenInfo.getPubKey());
    }

}
