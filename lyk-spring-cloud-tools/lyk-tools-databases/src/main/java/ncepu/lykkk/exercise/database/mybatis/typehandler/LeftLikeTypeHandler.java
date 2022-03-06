package ncepu.lykkk.exercise.database.mybatis.typehandler;

import org.apache.ibatis.type.Alias;

/**
 * @program: spring-cloud-exercise
 * @description: 仅仅用于like查询
 * @author: 林玉坤
 * @create: 2022-03-05 17:44
 **/
@Alias("leftLike")
public class LeftLikeTypeHandler extends BaseLikeTypeHandler{

    public LeftLikeTypeHandler() {
        super(true, false);
    }

}
