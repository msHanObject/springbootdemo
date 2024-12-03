package io.mshanobject.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import io.mshanobject.springbootdemo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying
    @Query("UPDATE Customer c SET c.point = c.point + :point WHERE c.id = :customerId")
    void increasePoint(@Param("customerId") Long customerId, @Param("point") int point);
} 