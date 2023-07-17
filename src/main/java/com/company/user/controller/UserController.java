package com.company.user.controller;

import com.company.base.ResDTO;
import com.company.config.details.EntityDetails;
import com.company.user.dto.UserDto;
import com.company.user.dto.UserUpdDTO;
import com.company.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    @Qualifier(value = "user-service")
    private final UserService userService;

    /**
     * ADMIN
     */

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addUser(@RequestBody UserDto dto){
        return ResponseEntity.ok(userService.addUser(dto));
    }

    @GetMapping("/by-id/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getByIdForAdmin(@PathVariable("id")String id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{status}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAllByStatus(@PathVariable("status") String status){
        return ResponseEntity.ok(userService.getAllByStatus(status));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable("id")String id){
        return ResponseEntity.ok(userService.delete(id));
    }


    @PutMapping("/unblock/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> unblockById(@PathVariable("id")String id){
        return ResponseEntity.ok(userService.unblock(id));
    }

    @PutMapping("/block/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> blockById(@PathVariable("id")String id){
        return ResponseEntity.ok(userService.block(id));
    }


    /**
     * USER
     */
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')")// t
    public ResponseEntity<?> getByIdForUser(){
        return ResponseEntity.ok(userService.getById(EntityDetails.getProfile().getId()));
    }

    @PutMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")// t
    public ResponseEntity<?> updateById(@RequestBody UserUpdDTO userUpdDTO){
        return ResponseEntity.ok(userService.update(userUpdDTO));
    }

    @DeleteMapping("/")
    @PreAuthorize("hasRole('ROLE_USER')")// t
    public ResponseEntity<?> deleteById(){
        return ResponseEntity.ok(userService.delete(EntityDetails.getProfile().getId()));
    }

    @PostMapping("/attach-upload")// t
    public ResponseEntity<ResDTO> attachUpload(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(userService.attachUpload(file));
    }

    @DeleteMapping("/attach-delete/{id}")// t
    public ResponseEntity<ResDTO> attachDelete(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.attachDelete(id));
    }

}


