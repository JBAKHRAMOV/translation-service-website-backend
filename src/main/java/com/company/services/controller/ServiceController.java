package com.company.services.controller;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.services.dto.ServiceReqDto;
import com.company.services.dto.ServiceResDto;
import com.company.services.dto.ServiceUpdDto;
import com.company.services.service.ServicesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
@AllArgsConstructor
public class ServiceController {
    @Qualifier(value = "services-service")
    private final ServicesService service;


    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> add(@RequestBody @Valid ServiceReqDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ServiceResDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> update(@RequestBody @Valid ServiceUpdDto dto) {
        return ResponseEntity.ok(service.update( dto));
    }

    @PutMapping("/change-status")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> changeStatus(@RequestBody @Valid ChangeStatusDto dto) {
        return ResponseEntity.ok(service.changeStatus(dto));
    }



    /**
     * without security
     */

    @GetMapping("/w-sec/")
    public ResponseEntity<List<ServiceResDto>> getAllOnlyPublished() {
        return ResponseEntity.ok(service.getAllOnlyPublish());
    }
}
