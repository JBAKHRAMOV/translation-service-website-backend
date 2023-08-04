package com.company.message.service;

import com.company.component.ResDTO;
import com.company.exp.ItemNotFoundException;
import com.company.message.dto.MessageReqDto;
import com.company.message.dto.MessageResDto;
import com.company.message.entity.MessageEntity;
import com.company.message.enums.MessageStatus;
import com.company.message.repository.MessageRepository;
import com.company.services.service.ServicesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "messages-service")
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;

    /**
     * ADMIN
     */

    @Override
    public List<MessageResDto> getAll() {

        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();

    }

    @Override
    public List<MessageResDto> getAllByStatus(MessageStatus status) {

        return repository.findAllByStatus(status)
                .stream()
                .map(this::entityToDto)
                .toList();

    }

    @Override
    public ResDTO changeStatus(String id) {

        MessageEntity entity = getById(id);

        entity.setStatus(MessageStatus.READ);

        repository.save(entity);

        return new ResDTO();

    }


    @Override
    public ResDTO delete(String id) {

        repository.delete(getById(id));

        return new ResDTO();

    }


    /**
     * without security
     */

    @Override
    public ResDTO add(MessageReqDto dto) {

        MessageEntity entity = new MessageEntity();
        entity.setFullName(entity.getFullName());
        entity.setPhoneNum(dto.getPhoneNum());
        entity.setEmail(dto.getEmail());
        entity.setMessage(entity.getMessage());
        entity.setStatus(MessageStatus.NEW);

        repository.save(entity);

        return new ResDTO();

    }

    /**
     * Component
     */

    private MessageEntity getById(String id) {

        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Message not found"));

    }

    private MessageResDto entityToDto(MessageEntity entity) {

        return MessageResDto.build(
                entity.getId(),
                entity.getFullName(),
                entity.getPhoneNum(),
                entity.getEmail(),
                entity.getMessage(),
                entity.getStatus(),
                entity.getCreatedDate()
        );

    }
}
