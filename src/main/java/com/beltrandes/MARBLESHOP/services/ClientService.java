package com.beltrandes.MARBLESHOP.services;

import com.beltrandes.MARBLESHOP.dtos.ClientDTO;
import com.beltrandes.MARBLESHOP.repositories.ClientRepository;
import com.beltrandes.MARBLESHOP.utils.mappers.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    public List<ClientDTO> findAllClients() {
        return clientRepository.findAll().stream().map(clientMapper::toDTO).toList();
    }
}
