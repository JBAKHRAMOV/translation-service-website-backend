package com.company.attach.controller;

import com.company.attach.service.AttachService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/attach")
@Slf4j
@RequiredArgsConstructor
public class AttachController {
    private final AttachService attachService;



    @GetMapping(value = "/open-general/{id}", produces = MediaType.ALL_VALUE)
    public byte[] open_general(@PathVariable("id") String key) {
        log.info("Attach open_general {}{}", key, AttachController.class);
        return attachService.openGeneral(key);
    }
}