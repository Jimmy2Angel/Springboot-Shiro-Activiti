package indi.baojie.demo.common.annotation;

import java.lang.annotation.*;

/**
 * Created by Lollipop on 2017/4/19.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
public @interface MapResult {
    String value();
}
