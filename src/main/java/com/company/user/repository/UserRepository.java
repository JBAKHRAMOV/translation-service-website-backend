package com.company.user.repository;

import com.company.user.entity.UserEntity;
import com.company.user.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByPhoneNum(String name);
    Optional<UserEntity> findByPhoneNumAndIsConfirm(String name, Boolean b);
    Optional<UserEntity> findByPhoneNumAndPassword(String phoneNum, String password);

    Optional<UserEntity> findByPassword(String email);
    Optional<UserEntity> findByIdAndIsConfirm(String id, Boolean b);
    List<UserEntity> findAllByStatus(UserStatus status);
}