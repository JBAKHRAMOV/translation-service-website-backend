package com.company.user.repository;

import com.company.user.entity.UserEntity;
import com.company.user.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByPhoneNum(String name);
    Optional<UserEntity> findByPhoneNumAndPassword(String phoneNum, String password);

    List<UserEntity> findAllByStatus(UserStatus status);
}