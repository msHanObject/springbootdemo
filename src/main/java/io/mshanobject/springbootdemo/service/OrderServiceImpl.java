package io.mshanobject.springbootdemo.service;

import io.mshanobject.springbootdemo.model.Order;
import io.mshanobject.springbootdemo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void addOrder(Order order) {
        // 1. order 테이블에 인서트
        // orderRepository.insertOrder();
        // 2. customer 테이블에 업데이트(고객 포인트 증가)
        // customerRepository.increaseCustomerPoint(30);
        // 3. delivery 테이블에 인서트
        // deliveryRepository.insertDeliveryInfo();
        // 4. 고객에게 주문완료 메일을 발송
        // mailRepository.sendOrderCompleteMail();
    }
}
