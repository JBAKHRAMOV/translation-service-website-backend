package com.company.message.controller;

import com.company.component.ResDTO;
import com.company.message.dto.MessageReqDto;
import com.company.message.dto.MessageResDto;
import com.company.message.enums.MessageStatus;
import com.company.message.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
@AllArgsConstructor
public class MessagesController {

        @Qualifier(value = "messages-service")
        private final MessageService service;



        @GetMapping("/all")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PUBLISHER')")
        public ResponseEntity<List<MessageResDto>> getAll() {
            return ResponseEntity.ok(service.getAll());
        }

        @GetMapping("/all/{status}")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PUBLISHER')")
        public ResponseEntity<List<MessageResDto>> getAllByStatus(@PathVariable(value = "status") MessageStatus status) {
                return ResponseEntity.ok(service.getAllByStatus(status));
        }

        @PutMapping("/change-status/{id}")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PUBLISHER')")
        public ResponseEntity<ResDTO> changeStatus(@PathVariable(value = "id") String id) {
            return ResponseEntity.ok(service.changeStatus(id));
        }

        @DeleteMapping("/{id}")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PUBLISHER')")
        public ResponseEntity<ResDTO> delete(@PathVariable(value = "id") String id) {
                return ResponseEntity.ok(service.delete(id));
        }



        /**
         * without security
         */

        @PostMapping("/w-sec/")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<ResDTO> add(@RequestBody MessageReqDto dto) {
                return ResponseEntity.ok(service.add(dto));
        }


}
