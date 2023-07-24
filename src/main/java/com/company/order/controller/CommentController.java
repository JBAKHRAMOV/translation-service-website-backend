package com.company.order.controller;

import com.company.component.ResDTO;
import com.company.order.dto.OrderChangeStatusDto;
import com.company.order.dto.OrderReqDto;
import com.company.order.dto.OrderResDto;
import com.company.order.enums.OrderStatus;
import com.company.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class CommentController {

        @Qualifier(value = "orders-service")
        private final OrderService service;



        @GetMapping("/all")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PUBLISHER')")
        public ResponseEntity<List<OrderResDto>> getAll() {
            return ResponseEntity.ok(service.getAll());
        }

        @GetMapping("/all/{status}")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PUBLISHER')")
        public ResponseEntity<List<OrderResDto>> getAllByStatus(@PathVariable(value = "status") OrderStatus status) {
                return ResponseEntity.ok(service.getAllByStatus(status));
        }

        @PutMapping("/change-status")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PUBLISHER')")
        public ResponseEntity<ResDTO> changeStatus(@RequestBody OrderChangeStatusDto dto) {
            return ResponseEntity.ok(service.changeStatus(dto));
        }

        /**
         * without security
         */

        @PostMapping("/w-sec/")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<ResDTO> add(@RequestBody OrderReqDto dto) {
                return ResponseEntity.ok(service.add(dto));
        }



}
