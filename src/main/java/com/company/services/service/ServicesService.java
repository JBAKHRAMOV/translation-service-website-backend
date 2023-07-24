package com.company.services.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.services.dto.ServiceReqDto;
import com.company.services.dto.ServiceResDto;
import com.company.services.dto.ServiceUpdDto;
import com.company.services.entity.ServiceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ServicesService {

    ResDTO add(ServiceReqDto dto);

    ResDTO update(ServiceUpdDto dto);

    ResDTO changeStatus(ChangeStatusDto dto);

    List<ServiceResDto> getAll();

    /**
     * without security
     */

    List<ServiceResDto> getAllOnlyPublish();

    /**
     * COMPONENT
     */

    ServiceEntity getById(String id);

    ServiceResDto entityToDto(ServiceEntity entity);
}
