package com.company.partner.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.component.ViewStatus;
import com.company.exp.ItemAlreadyExistsException;
import com.company.exp.ItemNotFoundException;
import com.company.partner.dto.PartnerReqDto;
import com.company.partner.dto.PartnerResDto;
import com.company.partner.dto.PartnerUpdDto;
import com.company.partner.entity.PartnerEntity;
import com.company.partner.repository.PartnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("partners-service")
@AllArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final PartnerRepository repository;

    /**
     * ADMIN
     */

    @Override
    public ResDTO add(PartnerReqDto dto) {

        Optional<PartnerEntity> optional = repository.findByName(dto.getName());

        if (optional.isPresent())
            throw new ItemAlreadyExistsException("Partner already exists");

        new PartnerEntity(
                dto.getIcon(),
                dto.getName(),
                dto.getLink(),
                dto.getStatus()
        );

        return new ResDTO();
    }

    @Override
    public ResDTO update(PartnerUpdDto dto) {

        PartnerEntity entity = getById(dto.getId());
        entity.setIcon(dto.getIcon());
        entity.setName(dto.getName());
        entity.setLink(dto.getLink());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public ResDTO changeStatus(ChangeStatusDto dto) {

        PartnerEntity entity = getById(dto.getId());
        entity.setStatus(dto.getStatus());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public List<PartnerResDto> getAll() {

        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    @Override
    public ResDTO delete(String id) {

        repository.delete(getById(id));

        return new ResDTO();
    }


    /**
     * USER
     */

    @Override
    public List<PartnerResDto> getAllOnlyPublish() {
        return repository.findAll()
                .stream()
                .filter(entity -> entity.getStatus().equals(ViewStatus.PUBLISH))
                .map(this::entityToDto)
                .toList();
    }

    /**
     * COMPONENT
     */

    private PartnerResDto entityToDto(PartnerEntity entity) {
        return new PartnerResDto(
                entity.getId(),
                entity.getIcon(),
                entity.getName(),
                entity.getLink(),
                entity.getStatus(),
                entity.getCreatedDate()
        );
    }

    private PartnerEntity getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Partner not found"));
    }
}
