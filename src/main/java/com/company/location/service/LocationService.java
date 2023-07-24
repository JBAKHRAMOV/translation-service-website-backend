package com.company.location.service;

import com.company.component.ChangeStatusDto;
import com.company.component.ResDTO;
import com.company.location.dto.LocationReqDto;
import com.company.location.dto.LocationResDto;
import com.company.location.dto.LocationUpdDto;

import java.util.List;


public interface LocationService {

    ResDTO add(LocationReqDto dto);

    ResDTO update(LocationUpdDto dto);

    ResDTO changeStatus(ChangeStatusDto dto);

    List<LocationResDto> getAll();

    ResDTO delete(String id);

    /**
     * without security
     */

    List<LocationResDto> getAllOnlyPublish();
}
