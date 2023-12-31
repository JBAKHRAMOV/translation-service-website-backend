package com.company.contact.controller;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.contact.dto.ContactReqDto;
import com.company.contact.dto.ContactResDto;
import com.company.contact.dto.ContactUpdDto;
import com.company.contact.service.ContactService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@AllArgsConstructor
public class ContactController {
    @Qualifier(value = "contacts-service")
    private final ContactService service;


    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> add(@RequestBody @Valid ContactReqDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ContactResDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> update(@RequestBody @Valid ContactUpdDto dto) {
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
    public ResponseEntity<List<ContactResDto>> getAllOnlyPublished() {
        return ResponseEntity.ok(service.getAllOnlyPublish());
    }
}
