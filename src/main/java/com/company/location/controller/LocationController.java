package com.company.location.controller;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.location.dto.LocationReqDto;
import com.company.location.dto.LocationResDto;
import com.company.location.dto.LocationUpdDto;
import com.company.location.service.LocationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
@AllArgsConstructor
public class LocationController {
    @Qualifier(value = "locations-service")
    private final LocationService service;


    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> add(@RequestBody @Valid LocationReqDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<LocationResDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> update(@RequestBody @Valid LocationUpdDto dto) {
        return ResponseEntity.ok(service.update( dto));
    }

    @PutMapping("/change-status")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> changeStatus(@RequestBody @Valid ChangeStatusDto dto) {
        return ResponseEntity.ok(service.changeStatus(dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> deleteById(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(service.delete(id));
    }



    /**
     * without security
     */

    @GetMapping("/w-sec/")
    public ResponseEntity<List<LocationResDto>> getAllOnlyPublished() {
        return ResponseEntity.ok(service.getAllOnlyPublish());
    }
}
