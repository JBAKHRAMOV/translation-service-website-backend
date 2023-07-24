package com.company.order.service;

import com.company.component.ResDTO;
import com.company.order.dto.OrderChangeStatusDto;
import com.company.order.dto.OrderReqDto;
import com.company.order.dto.OrderResDto;
import com.company.order.enums.OrderStatus;

import java.util.List;

public interface OrderService {
    /**
     * ADMIN
     */
    List<OrderResDto> getAll();
    List<OrderResDto> getAllByStatus(OrderStatus status);

    ResDTO changeStatus(OrderChangeStatusDto dto);



    /**
     * without security
     */

    ResDTO add(OrderReqDto dto);
}
