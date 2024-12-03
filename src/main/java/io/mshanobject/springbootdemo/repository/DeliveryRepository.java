package io.mshanobject.springbootdemo.repository;

import io.mshanobject.springbootdemo.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
} 