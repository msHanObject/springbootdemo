package io.mshanobject.springbootdemo.repository;

import io.mshanobject.springbootdemo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
