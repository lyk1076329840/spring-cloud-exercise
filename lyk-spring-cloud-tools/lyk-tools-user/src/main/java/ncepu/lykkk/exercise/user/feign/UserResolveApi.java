package ncepu.lykkk.exercise.user.feign;

import ncepu.lykkk.exercise.base.R;
import ncepu.lykkk.exercise.user.feign.fallback.UserResolveApiFallback;
import ncepu.lykkk.exercise.user.model.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: spring-cloud-exercise
 * @description: 用户操作API
 * @author: 林玉坤
 * @create: 2022-03-05 15:57
 **/
@FeignClient(name = "${pinda.feign.authority-server:pinda-auth-server}", fallbackFactory = UserResolveApiFallback.class)
public interface UserResolveApi {
    /**
     * 根据id 查询用户详情
     */
    @PostMapping(value = "/user/anno/id/{id}")
    R<SysUser> getById(@PathVariable("id") Long id, @RequestBody UserQuery userQuery);
}
