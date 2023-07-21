package com.company.language.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.component.ViewStatus;
import com.company.exp.ItemAlreadyExistsException;
import com.company.exp.ItemNotFoundException;
import com.company.language.dto.LanguageReqDto;
import com.company.language.dto.LanguageResDto;
import com.company.language.dto.LanguageUpdDto;
import com.company.language.entity.LanguageEntity;
import com.company.language.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "language-service-1")
@AllArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository repository;

    /**
     * ADMIN
     */

    @Override
    public ResDTO add(LanguageReqDto dto) {

        Optional<LanguageEntity> optional = repository.findByNameEng(dto.getNameEng());

        if (optional.isPresent())
            throw new ItemAlreadyExistsException("This language already exists !!!");

        repository.save(
                new LanguageEntity(
                        dto.getNameUz(),
                        dto.getNameRu(),
                        dto.getNameEng(),
                        ViewStatus.valueOf(dto.getStatus())
                )
        );

        return new ResDTO();
    }

    @Override
    public ResDTO update(String id, LanguageUpdDto dto) {
        LanguageEntity entity=getLanguage(id);

        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEng(dto.getNameEng());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public ResDTO changeStatus(ChangeStatusDto dto) {

        LanguageEntity entity=getLanguage(dto.getId());

        entity.setStatus(ViewStatus.valueOf(dto.getStatus()));

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public List<LanguageResDto> getAll() {

        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();

    }


    /**
     * without security
     */

    @Override
    public List<LanguageResDto> getAllOnlyPublish() {

        return repository.findAll()
                .stream()
                .filter(entity -> entity.getStatus().equals(ViewStatus.PUBLISH))
                .map(this::entityToDto)
                .toList();

    }

    /**
     * Component
     */

    private LanguageEntity getLanguage(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Language not found"));
    }

    private LanguageResDto entityToDto(LanguageEntity entity){
        return new LanguageResDto(
                entity.getId(),
                entity.getNameUz(),
                entity.getNameRu(),
                entity.getNameEng(),
                entity.getStatus(),
                entity.getCreatedDate()
        );
    }
}
