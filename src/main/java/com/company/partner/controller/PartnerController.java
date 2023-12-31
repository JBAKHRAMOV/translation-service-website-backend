package com.company.partner.controller;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.language.dto.LanguageReqDto;
import com.company.language.dto.LanguageResDto;
import com.company.language.dto.LanguageUpdDto;
import com.company.language.service.LanguageService;
import com.company.partner.dto.PartnerReqDto;
import com.company.partner.dto.PartnerResDto;
import com.company.partner.dto.PartnerUpdDto;
import com.company.partner.service.PartnerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partners")
@AllArgsConstructor
public class PartnerController {
    @Qualifier(value = "partners-service")
    private final PartnerService service;


    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> add(@RequestBody @Valid PartnerReqDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<PartnerResDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> update(@RequestBody @Valid PartnerUpdDto dto) {
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
    public ResponseEntity<List<PartnerResDto>> getAllOnlyPublished() {
        return ResponseEntity.ok(service.getAllOnlyPublish());
    }
}
