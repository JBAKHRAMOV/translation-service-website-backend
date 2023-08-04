package com.company.services.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.component.ViewStatus;
import com.company.exp.ItemAlreadyExistsException;
import com.company.exp.ItemNotFoundException;
import com.company.services.dto.ServiceReqDto;
import com.company.services.dto.ServiceResDto;
import com.company.services.dto.ServiceUpdDto;
import com.company.services.entity.ServiceEntity;
import com.company.services.repository.ServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service(value = "services-service")
@AllArgsConstructor
public class ServicesServiceImpl implements ServicesService {

    private final ServiceRepository repository;

    /**
     * ADMIN
     */
    @Override
    public ResDTO add(ServiceReqDto dto) {

        Optional<ServiceEntity> optional = repository.findByNameEng(dto.getNameEng());

        if (optional.isPresent())
            throw new ItemAlreadyExistsException("Service already exists !!!");

        repository.save(
                new ServiceEntity(
                        dto.getIcon(),
                        dto.getNameUz(),
                        dto.getNameRu(),
                        dto.getNameEng(),
                        dto.getShortInfoUz(),
                        dto.getShortInfoRu(),
                        dto.getShortInfoEng(),
                        dto.getFullInfoUz(),
                        dto.getFullInfoRu(),
                        dto.getFullInfoEng(),
                        dto.getStatus()
                )
        );

        return new ResDTO();
    }

    @Override
    public ResDTO update(ServiceUpdDto dto) {

        ServiceEntity entity = getById(dto.getId());

        entity.setIcon(dto.getIcon());
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEng(dto.getNameEng());
        entity.setShortInfoUz(dto.getShortInfoUz());
        entity.setShortInfoRu(dto.getShortInfoRu());
        entity.setShortInfoEng(dto.getShortInfoEng());
        entity.setFullInfoUz(dto.getFullInfoUz());
        entity.setFullInfoRu(dto.getFullInfoRu());
        entity.setFullInfoEng(dto.getFullInfoEng());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public ResDTO changeStatus(ChangeStatusDto dto) {

        ServiceEntity entity = getById(dto.getId());

        entity.setStatus(dto.getStatus());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public List<ServiceResDto> getAll() {

        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();

    }


    @Override
    public List<ServiceResDto> getAllOnlyPublish() {

        return repository.findAll()
                .stream()
                .filter(entity -> entity.getStatus().equals(ViewStatus.PUBLISH))
                .map(this::entityToDto)
                .toList();

    }

    /**
     * COMPONENT
     */

    @Override
    public ServiceEntity getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Service not found !!!"));
    }

    @Override
    public ServiceResDto entityToDto(ServiceEntity entity) {
        return new ServiceResDto(
                entity.getId(),
                entity.getIcon(),
                entity.getNameUz(),
                entity.getNameRu(),
                entity.getNameEng(),
                entity.getShortInfoUz(),
                entity.getShortInfoRu(),
                entity.getShortInfoEng(),
                entity.getFullInfoUz(),
                entity.getFullInfoRu(),
                entity.getFullInfoEng(),
                entity.getStatus(),
                entity.getCreatedDate()
        );
    }
}
