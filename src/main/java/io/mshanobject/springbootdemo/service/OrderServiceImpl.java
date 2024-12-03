package io.mshanobject.springbootdemo.service;

import io.mshanobject.springbootdemo.model.Order;
import io.mshanobject.springbootdemo.model.Delivery;
import io.mshanobject.springbootdemo.model.DeliveryStatus;
import io.mshanobject.springbootdemo.model.Event;
import io.mshanobject.springbootdemo.repository.OrderRepository;
import io.mshanobject.springbootdemo.repository.CustomerRepository;
import io.mshanobject.springbootdemo.repository.DeliveryRepository;
import io.mshanobject.springbootdemo.repository.MailRepository;
import io.mshanobject.springbootdemo.service.PointCalculationService;
import io.mshanobject.springbootdemo.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final DeliveryRepository deliveryRepository;
    private final MailRepository mailRepository;
    private final PointCalculationService pointCalculationService;
    private final EventRepository eventRepository;

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
        
        int points = pointCalculationService.calculateOrderPoints(order);
        // 현재 진행중인 이벤트들에 대한 추가 포인트 계산
        LocalDateTime now = LocalDateTime.now();
        List<Event> activeEvents = eventRepository.findCurrentEvents(now);
        for (Event event : activeEvents) {
            points += event.getBonusPoint();
        }
        customerRepository.increasePoint(order.getCustomer().getId(), points);
        
        // 3. delivery 테이블에 인서트
        Delivery delivery = Delivery.builder()
            .orderId(order.getId())
            .status(DeliveryStatus.PENDING)
            .build();
        deliveryRepository.save(delivery);
        
        // 4. 고객에게 주문완료 메일을 발송
        mailRepository.sendOrderCompleteMail();
    }
}
