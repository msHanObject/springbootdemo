package io.mshanobject.springbootdemo.service;

import io.mshanobject.springbootdemo.model.Order;
import org.springframework.stereotype.Service;

@Service
public class PointCalculationService {
    
    public int calculateOrderPoints(Order order) {
        // 기본 포인트 계산 로직
        return 100; // 임시 반환값
    }
    
    public int calculateEventPoints(Order order, String eventType) {
        // 이벤트 추가 포인트 계산 로직
        return 50; // 임시 반환값
    }
} 