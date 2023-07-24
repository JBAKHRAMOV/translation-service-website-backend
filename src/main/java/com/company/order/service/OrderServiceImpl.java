package com.company.order.service;

import com.company.component.ResDTO;
import com.company.exp.ItemNotFoundException;
import com.company.language.entity.LanguageEntity;
import com.company.language.service.LanguageService;
import com.company.order.dto.OrderChangeStatusDto;
import com.company.order.dto.OrderReqDto;
import com.company.order.dto.OrderResDto;
import com.company.order.entity.OrderEntity;
import com.company.order.enums.OrderStatus;
import com.company.order.repository.OrderRepository;
import com.company.services.entity.ServiceEntity;
import com.company.services.service.ServicesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "orders-service")
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final ServicesService servicesService;
    private final LanguageService languageService;


    /**
     * ADMIN, PUBLISHER
     */

    @Override
    public List<OrderResDto> getAll() {

        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();

    }

    @Override
    public List<OrderResDto> getAllByStatus(OrderStatus status) {

        return repository.findAllByStatus(status)
                .stream()
                .map(this::entityToDto)
                .toList();

    }

    @Override
    public ResDTO changeStatus(OrderChangeStatusDto dto) {

        OrderEntity entity = getById(dto.getId());
        entity.setStatus(dto.getStatus());

        repository.save(entity);

        return  new ResDTO();
    }

    /**
     * USER
     */

    @Override
    public ResDTO add(OrderReqDto dto) {
        ServiceEntity service = servicesService.getById(dto.getServiceId());
        LanguageEntity languageTo = languageService.getById(dto.getLanguageIdTo());
        LanguageEntity languageFrom = languageService.getById(dto.getLanguageIdFrom());

        OrderEntity entity=new OrderEntity();
        entity.setFullName(dto.getFullName());
        entity.setPhoneNum(dto.getPhoneNum());
        entity.setMessage(dto.getMessage());
        entity.setWordCount(dto.getWordCount());
        entity.setStatus(OrderStatus.NEW);
        entity.setService(service);
        entity.setLanguageTo(languageTo);
        entity.setLanguageFrom(languageFrom);

        repository.save(entity);

        return new ResDTO();
    }

    /**
     * Component
     */

    private OrderEntity getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Order not found"));
    }

    private OrderResDto entityToDto(OrderEntity entity){
        return new OrderResDto(
                entity.getId(),
                entity.getFullName(),
                entity.getPhoneNum(),
                entity.getMessage(),
                entity.getWordCount(),
                servicesService.entityToDto(entity.getService()),
                languageService.entityToDto(entity.getLanguageTo()),
                languageService.entityToDto(entity.getLanguageFrom()),
                entity.getStatus(),
                entity.getCreatedDate()
        );
    }


}
