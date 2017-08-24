package indi.baojie.supervision.dao;


import java.util.List;

public interface BaseMapper<T> {
    int insert(T t);

    int delete(T t);

    int update(T t);

    int count(T t);

    List<T> find(T t);

    T findOne(T t);

}
