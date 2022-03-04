package ncepu.lykkk.exercise.utils;

import com.google.common.collect.ImmutableMap;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;
import java.util.function.Function;



/**
 * @program: spring-cloud-exercise
 * @description: Map类增强
 * @author: 林玉坤
 * @create: 2022-03-02 11:26
 **/
public class MapHelper {

    public static <K, V, M> ImmutableMap<K, M> uniqueIndex(Iterable<V> values, Function<? super V, K> keyFunction, Function<? super V, M> valueFunction) {
        Iterator<V> iterator = values.iterator();
        checkNotNull(keyFunction);
        checkNotNull(valueFunction);
        ImmutableMap.Builder<K, M> builder = ImmutableMap.builder();
        while (iterator.hasNext()) {
            V value = iterator.next();
            builder.put(keyFunction.apply(value), valueFunction.apply(value));
        }
        try {
            return builder.build();
        } catch (IllegalArgumentException duplicateKeys) {
            throw new IllegalArgumentException(
                    duplicateKeys.getMessage()
                            + ".若要在键下索引多个值，请使用: Multimaps.index.");
        }
    }

}
