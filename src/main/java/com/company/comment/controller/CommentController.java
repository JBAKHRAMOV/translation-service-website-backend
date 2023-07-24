package com.company.comment.controller;

import com.company.comment.dto.CommentReqDto;
import com.company.comment.dto.CommentResDto;
import com.company.comment.service.CommentService;
import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@AllArgsConstructor
public class CommentController {

        @Qualifier(value = "comments-service")
        private final CommentService service;



        @GetMapping("/all")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PUBLISHER')")
        public ResponseEntity<List<CommentResDto>> getAll() {
            return ResponseEntity.ok(service.getAll());
        }

        @PutMapping("/change-status")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PUBLISHER')")
        public ResponseEntity<ResDTO> changeStatus(@RequestBody ChangeStatusDto dto) {
            return ResponseEntity.ok(service.changeStatus(dto));
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
        public ResponseEntity<ResDTO> add(@RequestBody CommentReqDto dto) {
                return ResponseEntity.ok(service.add(dto));
        }

        @GetMapping("/w-sec/all")
        public ResponseEntity<List<CommentResDto>> getAllOnlyPublished() {
            return ResponseEntity.ok(service.getAllOnlyPublish());
        }


}
