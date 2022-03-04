package ncepu.lykkk.exercise.converter;

import org.springframework.core.convert.converter.Converter;

import ncepu.lykkk.exercise.utils.DateUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: spring-cloud-exercise
 * @description: 解决入参为Date类型
 * @author: 林玉坤
 * @create: 2022-03-03 22:03
 **/
public class String2LocalTimeConverter extends BaseDateConverter<LocalTime> implements Converter<String, LocalTime> {

    protected static final Map<String, String> FORMAT = new LinkedHashMap(1);

    static {
        FORMAT.put(DateUtils.DEFAULT_TIME_FORMAT, "^\\d{1,2}:\\d{1,2}:\\d{1,2}$");
    }

    @Override
    protected Map<String, String> getFormat() {
        return FORMAT;
    }

    @Override
    public LocalTime convert(String source) {
        return super.convert(source, (key) -> LocalTime.parse(source, DateTimeFormatter.ofPattern(key)));
    }
}
