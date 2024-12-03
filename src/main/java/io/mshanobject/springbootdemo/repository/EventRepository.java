package io.mshanobject.springbootdemo.repository;

import io.mshanobject.springbootdemo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStartDateBeforeAndEndDateAfter(LocalDateTime startDateTime, LocalDateTime enDateTime);
    
    List<Event> findCurrentEvents(LocalDateTime now);
} 