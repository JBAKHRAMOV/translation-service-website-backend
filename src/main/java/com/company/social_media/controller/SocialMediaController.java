package com.company.social_media.controller;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.social_media.dto.SocialMediaReqDto;
import com.company.social_media.dto.SocialMediaResDto;
import com.company.social_media.dto.SocialMediaUpdDto;
import com.company.social_media.service.SocialMediaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/social-media")
@AllArgsConstructor
public class SocialMediaController {
    @Qualifier(value = "social-media-service")
    private final SocialMediaService service;


    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> add(@RequestBody SocialMediaReqDto dto) {
        return ResponseEntity.ok(service.add(dto));
    }
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<SocialMediaResDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> update(@RequestBody SocialMediaUpdDto dto) {
        return ResponseEntity.ok(service.update( dto));
    }

    @PutMapping("/change-status")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ResDTO> changeStatus(@RequestBody ChangeStatusDto dto) {
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

    @GetMapping("/w-sec/all")
    public ResponseEntity<List<SocialMediaResDto>> getAllOnlyPublished() {
        return ResponseEntity.ok(service.getAllOnlyPublish());
    }
}