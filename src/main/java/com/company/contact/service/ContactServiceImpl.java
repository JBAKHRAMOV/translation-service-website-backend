package com.company.contact.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.component.ViewStatus;
import com.company.contact.dto.ContactReqDto;
import com.company.contact.dto.ContactResDto;
import com.company.contact.dto.ContactUpdDto;
import com.company.contact.entity.ContactEntity;
import com.company.contact.repository.ContactRepository;
import com.company.exp.ItemAlreadyExistsException;
import com.company.exp.ItemNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service(value = "contacts-service")
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;

    /**
     * ADMIN
     */
    @Override
    public ResDTO add(ContactReqDto dto) {

        Optional<ContactEntity> optional = repository.findByInfo(dto.getInfo());

        if (optional.isPresent())
            throw new ItemAlreadyExistsException("Contact already exists !!!");

        repository.save(
                new ContactEntity(
                        dto.getIcon(),
                        dto.getInfo(),
                        dto.getStatus()
                )
        );

        return new ResDTO();
    }

    @Override
    public ResDTO update(ContactUpdDto dto) {

        ContactEntity entity = getById(dto.getId());

        entity.setIcon(dto.getIcon());
        entity.setInfo(dto.getInfo());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public ResDTO changeStatus(ChangeStatusDto dto) {

        ContactEntity entity = getById(dto.getId());

        entity.setStatus(dto.getStatus());

        repository.save(entity);

        return new ResDTO();
    }

    @Override
    public List<ContactResDto> getAll() {

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
    public List<ContactResDto> getAllOnlyPublish() {

        return repository.findAll()
                .stream()
                .filter(entity -> entity.getStatus().equals(ViewStatus.PUBLISH))
                .map(this::entityToDto)
                .toList();

    }

    /**
     * COMPONENT
     */

    private ContactEntity getById(String id) {

        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Contact not found !!!"));
    }

    private ContactResDto entityToDto(ContactEntity entity) {
        return new ContactResDto(
                entity.getId(),
                entity.getIcon(),
                entity.getInfo(),
                entity.getStatus(),
                entity.getCreatedDate()
        );
    }
}
