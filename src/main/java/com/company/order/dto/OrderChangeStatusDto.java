package com.company.order.dto;


import com.company.order.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderChangeStatusDto {
    private String id;
    private OrderStatus status;
}
