package com.company.social_media.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.component.ViewStatus;
import com.company.exp.ItemAlreadyExistsException;
import com.company.exp.ItemNotFoundException;
import com.company.social_media.dto.SocialMediaReqDto;
import com.company.social_media.dto.SocialMediaResDto;
import com.company.social_media.dto.SocialMediaUpdDto;
import com.company.social_media.entity.SocialMediaEntity;
import com.company.social_media.repository.SocialMediaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service(value = "social-medias-service")
@AllArgsConstructor
public class SocialMediaServiceImpl implements SocialMediaService {

    private final SocialMediaRepository repository;

    /**
     * ADMIN
     */
    @Override
    public ResDTO add(SocialMediaReqDto dto) {

        Optional<SocialMediaEntity> optional = repository.findByName(dto.getName());

        if (optional.isPresent())
            throw new ItemAlreadyExistsException("Social media already exists !!!");

        repository.save(
                new SocialMediaEntity(
                        dto.getIcon(),
                        dto.getName(),
                        dto.getLink(),
                        dto.getStatus()
                )
        );

        return new ResDTO();
    }

    @Override
    public ResDTO update(SocialMediaUpdDto dto) {

        SocialMediaEntity entity = getById(dto.getId());

        entity.setIcon(dto.getIcon());
        entity.setName(dto.getName());
        entity.setLink(dto.getLink());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public ResDTO changeStatus(ChangeStatusDto dto) {

        SocialMediaEntity entity = getById(dto.getId());

        entity.setStatus(dto.getStatus());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public List<SocialMediaResDto> getAll() {

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
    public List<SocialMediaResDto> getAllOnlyPublish() {

        return repository.findAll()
                .stream()
                .filter(entity -> entity.getStatus().equals(ViewStatus.PUBLISH))
                .map(this::entityToDto)
                .toList();

    }

    /**
     * COMPONENT
     */

    private SocialMediaEntity getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Social media not found !!!"));
    }

    private SocialMediaResDto entityToDto(SocialMediaEntity entity) {
        return new SocialMediaResDto(
                entity.getId(),
                entity.getIcon(),
                entity.getName(),
                entity.getLink(),
                entity.getStatus(),
                entity.getCreatedDate()
        );
    }
}
