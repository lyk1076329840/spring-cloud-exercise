package ncepu.lykkk.exercise.base;

import java.util.Arrays;
import java.util.Map;

import ncepu.lykkk.exercise.utils.MapHelper;

/**
 * @program: spring-cloud-exercise
 * @description: 枚举类型基类
 * @author: 林玉坤
 * @create: 2022-03-03 15:59
 **/
public interface BaseEnum {

    /**
     * 将制定的枚举集合转成 map
     * key -> name
     * value -> desc
     *
     * @param list
     * @return
     */
    static Map<String, String> getMap(BaseEnum[] list) {
        return MapHelper.uniqueIndex(Arrays.asList(list), BaseEnum::getCode, BaseEnum::getDesc);
    }


    /**
     * 编码重写
     *
     * @return
     */
    default String getCode() {
        return toString();
    }

    /**
     * 描述
     *
     * @return
     */
    String getDesc();

}
