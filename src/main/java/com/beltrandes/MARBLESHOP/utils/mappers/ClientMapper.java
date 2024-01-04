package com.beltrandes.MARBLESHOP.utils.mappers;

import com.beltrandes.MARBLESHOP.domain.Client;
import com.beltrandes.MARBLESHOP.dtos.ClientDTO;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDTO toDTO(Client entity) {
        return new ClientDTO(entity.getId(), entity.getName(), entity.getPhone(), entity.getEmail(), entity.getAddress());
    }

    public Client toEntity(ClientDTO dto) {
        return new Client(dto.id(), dto.name(), dto.phone(), dto.email(), dto.address());
    }
}
