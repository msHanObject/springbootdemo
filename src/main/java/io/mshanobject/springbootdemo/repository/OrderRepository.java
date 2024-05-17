package io.mshanobject.springbootdemo.repository;

import io.mshanobject.springbootdemo.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderRepository {
    public void insertOrder(Order order);
}
