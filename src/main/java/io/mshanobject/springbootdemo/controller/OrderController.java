package io.mshanobject.springbootdemo.controller;

import io.mshanobject.springbootdemo.model.Article;
import io.mshanobject.springbootdemo.model.Order;
import io.mshanobject.springbootdemo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public void postOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }
}
