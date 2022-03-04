package ncepu.lykkk.exercise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: spring-cloud-exercise
 * @description: 树接口
 * @author: 林玉坤
 * @create: 2022-03-03 15:42
 **/
public interface ITreeNode<T, I extends Serializable> {

    /**
     * 添加
     *
     * @param node
     */
//    void add(T node);

    /**
     * 获取id
     *
     * @return
     */
    I getId();

    /**
     * 获取父id
     *
     * @return
     */
    I getParentId();

    /**
     * 获取子类
     *
     * @return
     */
    List<T> getChildren();

    /**
     * 设置子类
     *
     * @param children
     */
    void setChildren(List<T> children);

    /**
     * 初始化子类
     */
    default void initChildren() {
        if (getChildren() == null) {
            this.setChildren(new ArrayList<>());
        }
    }

}
