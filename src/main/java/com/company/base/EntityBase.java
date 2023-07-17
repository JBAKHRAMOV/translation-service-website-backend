package com.company.base;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class EntityBase {
    @Id
    @Column(name = "id", nullable = false)
    private String id=UUID.randomUUID().toString();

    @CreatedDate
    private LocalDateTime createdDate=LocalDateTime.now();
}
