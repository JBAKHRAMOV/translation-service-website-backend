package com.company.location.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.component.ViewStatus;
import com.company.exp.ItemAlreadyExistsException;
import com.company.exp.ItemNotFoundException;
import com.company.location.dto.LocationReqDto;
import com.company.location.dto.LocationResDto;
import com.company.location.dto.LocationUpdDto;
import com.company.location.entity.LocationEntity;
import com.company.location.repository.LoactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service(value = "locations-service")
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LoactionRepository repository;

    /**
     * ADMIN
     */
    @Override
    public ResDTO add(LocationReqDto dto) {

        Optional<LocationEntity> optional = repository.findByName(dto.getName());

        if (optional.isPresent())
            throw new ItemAlreadyExistsException("Location already exists !!!");

        repository.save(
                new LocationEntity(
                        dto.getName(),
                        dto.getLink(),
                        dto.getStatus()
                )
        );

        return new ResDTO();

    }

    @Override
    public ResDTO update(LocationUpdDto dto) {

        LocationEntity entity = getById(dto.getId());

        entity.setName(dto.getName());
        entity.setLink(dto.getLink());

        repository.save(entity);

        return new ResDTO();

    }

    @Override
    public ResDTO changeStatus(ChangeStatusDto dto) {

        LocationEntity entity = getById(dto.getId());

        entity.setStatus(dto.getStatus());

        repository.save(entity);

        return new ResDTO();

    }

    @Override
    public List<LocationResDto> getAll() {

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
    public List<LocationResDto> getAllOnlyPublish() {

        return repository.findAll()
                .stream()
                .filter(entity -> entity.getStatus().equals(ViewStatus.PUBLISH))
                .map(this::entityToDto)
                .toList();

    }

    /**
     * COMPONENT
     */

    private LocationEntity getById(String id) {

        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Location not found !!!"));

    }

    private LocationResDto entityToDto(LocationEntity entity) {

        return new LocationResDto(
                entity.getId(),
                entity.getName(),
                entity.getLink(),
                entity.getStatus(),
                entity.getCreatedDate()
        );

    }
}
