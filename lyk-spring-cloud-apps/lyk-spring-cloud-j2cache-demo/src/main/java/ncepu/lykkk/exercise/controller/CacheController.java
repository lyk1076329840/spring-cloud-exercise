package ncepu.lykkk.exercise.controller;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: spring-cloud-exercise
 * @description: 缓存控制类
 * 使用j2cache提供的CacheChannel对象操作缓存数据
 * @author: 林玉坤
 * @create: 2022-03-06 20:11
 **/
@RestController
@RequestMapping("/cache")
public class CacheController {

    private String key = "myKey";

    private String region = "rx";

    @Resource
    private CacheChannel cacheChannel;

    @GetMapping("/getInfos")
    public List<String> getInfos(){

        //从缓存中获取数据，需要制定区域region与key
        CacheObject cacheObject = cacheChannel.get(region,key);

        if(cacheObject.getValue() == null){
            //缓存中没有找到，查询数据库获得
            List<String> data = new ArrayList<String>();

            data.add("info1");
            data.add("info2");

            //放入缓存
            cacheChannel.set(region, key, data);
            return data;
        }

        return (List<String>) cacheObject.getValue();
    }

    //清理指定key缓存
    //两级缓存全部清理
    @GetMapping("/evict")
    public String evict(){
        cacheChannel.evict(region,key);
        return "evict success";
    }

    //清理指定region所有缓存
    //两级缓存全部清理
    @GetMapping("/clear")
    public String clear(){
        cacheChannel.clear(region);
        return "clear success";
    }

    //检查指定的缓存是否存在
    @GetMapping("/exists")
    public boolean exists(){
        return cacheChannel.exists(region,key);
    }

    //检查指定的缓存数据是从哪一级缓存获取到的
    @GetMapping("/check")
    public String check(){
        int level = cacheChannel.check(region, key);
        return "level:" + level;
    }

}
