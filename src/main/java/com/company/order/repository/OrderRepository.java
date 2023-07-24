package com.company.order.repository;

import com.company.component.ViewStatus;
import com.company.order.entity.OrderEntity;
import com.company.order.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {

    List<OrderEntity> findAllByStatus(OrderStatus status);
}