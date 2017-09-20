package indi.baojie.supervision.dao;

import indi.baojie.supervision.domain.Point;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lollipop on 17/9/19
 */
@Mapper
public interface PointMapper extends BaseMapper<Point> {

    Point findByName(@Param("name") String name);
}
