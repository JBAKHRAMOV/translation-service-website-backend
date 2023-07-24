package com.company.message.repository;

import com.company.message.entity.MessageEntity;
import com.company.message.enums.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, String> {

    List<MessageEntity> findAllByStatus(MessageStatus status);

}