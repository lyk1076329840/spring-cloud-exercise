package ncepu.lykkk.exercise;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: spring-cloud-exercise
 * @description: logback日志组件测试使用
 * @author: 林玉坤
 * @create: 2022-03-07 20:45
 **/
public class LogbackTest {

    @Test
    public void test1(){
        //Logback主要有三个类：Logger, Appender, Layout
        //Appender可以指定输出位置 控制台/文件/数据库

        //通过工厂对象获得一个logger日志记录器对象
        //name 没有什么规范
        //记录器对象是个树形层次关系
        final Logger logger = LoggerFactory.getLogger("ncepu.lykkk.exercise");
        //当前logger对象日志输出级别debug 是从root logger继承来的 只能输出debug及以上的级别
        //使用trace级别记录日志 其中trace级别不够不能输出
        logger.trace("trace...");
        logger.debug("debug...");
        logger.info("info...");
        logger.warn("warn...");
        logger.error("error...");
    }

    @Test
    public void test2(){
        final Logger logger = LoggerFactory.getLogger("ncepu.lykkk.exercise");
        logger.debug("debug...");

        //打印内部状态
        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
        //BasicConfigurator 控制台输出的目的地
    }

    /**
     * 日志输出级别 ERROR -> WARN -> INFO -> DEBUG -> TRACE
     */
    //测试默认输出的级别
    @Test
    public void test3(){
        final Logger logger = LoggerFactory.getLogger("ncepu.lykkk.exercise");

        logger.trace("trace...");
        logger.debug("debug...");
        logger.info("info...");
        logger.warn("warn...");
        logger.error("error...");
    }

    //设置日志输出等级
    @Test
    public void test4(){
        final Logger logger = LoggerFactory.getLogger("ncepu.lykkk.exercise");
        ch.qos.logback.classic.Logger logger1 = (ch.qos.logback.classic.Logger) logger;
        //Level.OFF 所有日志都不输出
        logger1.setLevel(Level.INFO); //设置当前日志记录器对象的日志输出

        /**
         * output:
         * info...
         * warn...
         * error...
         */
        logger1.trace("trace...");
        logger1.debug("debug...");
        logger1.info("info...");
        logger1.warn("warn...");
        logger1.error("error...");
    }

    //测试Logger的继承
    @Test
    public void test5(){
        final Logger logger = LoggerFactory.getLogger("ncepu.lykkk");
        ch.qos.logback.classic.Logger logger1 = (ch.qos.logback.classic.Logger) logger;
        //Level.OFF 所有日志都不输出
        logger1.setLevel(Level.INFO); //设置当前日志记录器对象的日志输出

        //继承logger1 即 继承logger1的等级（Level.INFO）
        /**
         * output:
         * info...
         * warn...
         * error...
         */
        Logger logger2 = LoggerFactory.getLogger("ncepu.lykkk.test");
        logger2.trace("trace...");
        logger2.debug("debug...");
        logger2.info("info...");
        logger2.warn("warn...");
        logger2.error("error...");
    }

    //Logger的获取，根据同一个名称获取的logger都是同一个实例
    @Test
    public void test6(){
        Logger logger1 = LoggerFactory.getLogger("ncepu.lykkk.test");
        Logger logger2 = LoggerFactory.getLogger("ncepu.lykkk.test");
        //output: true
        System.out.println(logger1 == logger2);
    }

    //参数化日志
    @Test
    public void test7(){
        Logger logger = LoggerFactory.getLogger("ncepu.lykkk");
        String value = "test";
        logger.info("参数值为：" + value);
        //使用占位符的方式进行参数的拼接
        logger.debug("hello {}","world");
    }

}
