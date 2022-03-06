package ncepu.lykkk.exercise.database.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static ncepu.lykkk.exercise.database.properties.DatabaseProperties.PREFIX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: spring-cloud-exercise
 * @description: 客户端认证配置
 * @author: 林玉坤
 * @create: 2022-03-05 17:36
 **/
@ConfigurationProperties(prefix = PREFIX)
@Data
@NoArgsConstructor
public class DatabaseProperties {

    public static final String PREFIX = "lyk.database";
    /**
     * 攻击 SQL 阻断解析器
     */
    public Boolean isBlockAttack = false;
    /**
     * 是否启用数据权限
     */
    //private Boolean isDataScope = true;
    /**
     * 事务超时时间
     */
    private int txTimeout = 60 * 60;
    /**
     * 统一管理事务的方法名
     */
    private List<String> transactionAttributeList = new ArrayList<>(Arrays.asList("add*", "save*", "insert*",
            "create*", "update*", "edit*", "upload*", "delete*", "remove*",
            "clean*", "recycle*", "batch*", "mark*", "disable*", "enable*", "handle*", "syn*",
            "reg*", "gen*", "*Tx"
    ));
    /**
     * 事务扫描基础包
     */
    private String transactionScanPackage = "ncepu.lykkk.exercise";

}
