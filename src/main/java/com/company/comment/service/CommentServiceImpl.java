package com.company.comment.service;

import com.company.comment.dto.CommentReqDto;
import com.company.comment.dto.CommentResDto;
import com.company.comment.entity.CommentEntity;
import com.company.comment.repository.CommentRepository;
import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.component.ViewStatus;
import com.company.config.details.EntityDetails;
import com.company.exp.ItemNotFoundException;
import com.company.services.entity.ServiceEntity;
import com.company.services.service.ServicesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service(value = "comments-service")
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    @Qualifier(value = "services-service")
    private final ServicesService servicesService;

    /**
     * ADMIN
     */

    @Override
    public ResDTO changeStatus(ChangeStatusDto dto) {

        CommentEntity entity= getById(dto.getId());

        entity.setStatus(dto.getStatus());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public List<CommentResDto> getAll() {

        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();

    }

    @Override
    public ResDTO delete(String id){

        repository.delete(getById(id));

        log.info("Comment delete with id: {}  by {} : ", id, EntityDetails.getProfile().getPhoneNum());

        return new ResDTO();
    }


    /**
     * without security
     */

    @Override
    public ResDTO add(CommentReqDto dto) {

        ServiceEntity service = servicesService.getById(dto.getServiceId());

        CommentEntity entity=new CommentEntity();
        entity.setFullName(entity.getFullName());
        entity.setMessage(entity.getMessage());
        entity.setStatus(ViewStatus.UN_PUBLISH);
        entity.setService(service);

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public List<CommentResDto> getAllOnlyPublish() {

        return repository.findAll()
                .stream()
                .filter(entity -> entity.getStatus().equals(ViewStatus.PUBLISH))
                .map(this::entityToDto)
                .toList();

    }

    /**
     * Component
     */

    private CommentEntity getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Comment not found"));
    }

    private CommentResDto entityToDto(CommentEntity entity){
        return new CommentResDto(
                entity.getId(),
                entity.getFullName(),
                entity.getMessage(),
                servicesService.entityToDto(entity.getService()),
                entity.getStatus(),
                entity.getCreatedDate()
        );
    }
}
