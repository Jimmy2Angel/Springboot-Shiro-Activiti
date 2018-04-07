package indi.baojie.supervision.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: lollipop
 * @date: 17/12/19
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private AtomicInteger count = new AtomicInteger(0);

    private int readsize;

    public DynamicDataSource(int readsize) {
        this.readsize = readsize;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DynamicDataSourceContextHolder.getJdbcType();
        if (typeKey == null) {
            System.out.println("无法确定数据源");
            return DataSourceType.WRITE.getType();
        }
        if (typeKey.equals(DataSourceType.WRITE.getType())) {
            return DataSourceType.WRITE.getType();
        }
        //读库进行负载均衡
        int a = count.getAndAdd(1);
        int lookupkey = a % readsize;
        return lookupkey;
    }

}
