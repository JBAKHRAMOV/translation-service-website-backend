package com.company.language.controller;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.language.dto.LanguageReqDto;
import com.company.language.dto.LanguageResDto;
import com.company.language.dto.LanguageUpdDto;
import com.company.language.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/language")
@AllArgsConstructor
public class LanguageController {

        @Qualifier(value = "language-service-1")
        private final LanguageService service;


        @PostMapping("/add")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<ResDTO> add(@RequestBody LanguageReqDto dto) {
            return ResponseEntity.ok(service.add(dto));
        }
        @GetMapping("/all")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<List<LanguageResDto>> getAll() {
            return ResponseEntity.ok(service.getAll());
        }

        @PutMapping("/update")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<ResDTO> update(@RequestBody LanguageUpdDto dto) {
            return ResponseEntity.ok(service.update(dto));
        }

        @PutMapping("/change-status")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<ResDTO> changeStatus(@RequestBody ChangeStatusDto dto) {
            return ResponseEntity.ok(service.changeStatus(dto));
        }



        /**
         * without security
         */

        @GetMapping("/w-sec/all")
        public ResponseEntity<List<LanguageResDto>> getAllOnlyPublished() {
            return ResponseEntity.ok(service.getAllOnlyPublish());
        }


}
