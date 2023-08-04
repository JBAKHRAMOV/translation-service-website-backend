package com.company.order.dto;


import com.company.order.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderChangeStatusDto {
    @NotBlank @NotNull
    private String id;
    @NotBlank @NotNull
    private OrderStatus status;
}
