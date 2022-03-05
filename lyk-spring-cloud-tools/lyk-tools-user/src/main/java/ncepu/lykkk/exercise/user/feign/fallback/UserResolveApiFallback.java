package ncepu.lykkk.exercise.user.feign.fallback;

import lombok.extern.slf4j.Slf4j;
import ncepu.lykkk.exercise.base.R;
import ncepu.lykkk.exercise.user.feign.UserQuery;
import ncepu.lykkk.exercise.user.feign.UserResolveApi;
import ncepu.lykkk.exercise.user.model.SysUser;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @program: spring-cloud-exercise
 * @description: 用户API熔断
 * @author: 林玉坤
 * @create: 2022-03-05 16:00
 **/
@Component
@Slf4j
public class UserResolveApiFallback implements FallbackFactory<UserResolveApi> {

    @Override
    public UserResolveApi create(final Throwable throwable) {
        return new UserResolveApi() {
            /**
             * 根据id 查询用户详情
             *
             * @param id
             * @param userQuery
             * @return
             */
            @Override
            public R<SysUser> getById(Long id, UserQuery userQuery) {
                log.error("通过用户名查询用户异常:{}", id, throwable);
                return R.timeout();
            }
        };
    }

}
