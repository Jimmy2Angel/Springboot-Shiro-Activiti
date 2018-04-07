package indi.baojie.supervision.config.db;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: lollipop
 * @date: 17/12/19
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("execution(* indi.baojie..*.*ServiceImpl.find*(..)) ")
    public void setReadDataSourceType() {
        logger.debug("拦截[read]操作");
        DynamicDataSourceContextHolder.read();
    }

    @Before("execution(* indi.baojie..*.*ServiceImpl.insert*(..)) " +
            "|| execution(* indi.baojie..*.*ServiceImpl.save*(..))" +
            "|| execution(* indi.baojie..*.*ServiceImpl.update*(..))" +
            "|| execution(* indi.baojie..*.*ServiceImpl.del*(..))")
    public void setWriteDataSourceType() {
        logger.debug("拦截[write]操作");
        DynamicDataSourceContextHolder.write();
    }
}
