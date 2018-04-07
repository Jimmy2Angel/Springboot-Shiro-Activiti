package indi.baojie.supervision.config.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lollipop
 * @date: 17/12/19
 */
public class DynamicDataSourceContextHolder {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    private final static ThreadLocal<String> local = new ThreadLocal<>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    public static void read() {
        logger.debug("切换至[读]数据源");
        local.set(DataSourceType.READ.getType());
    }

    public static void write() {
        logger.debug("切换至[写]数据源");
        local.set(DataSourceType.WRITE.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }

}
