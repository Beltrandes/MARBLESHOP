package com.beltrandes.MARBLESHOP.services;

import com.beltrandes.MARBLESHOP.dtos.ClientDTO;
import com.beltrandes.MARBLESHOP.repositories.ClientRepository;
import com.beltrandes.MARBLESHOP.utils.exceptions.ObjectNotFoundException;
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

    public ClientDTO findClientById(String id) {
        return clientMapper.toDTO(clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id)));
    }

    public ClientDTO insertClient(ClientDTO client) {
        return clientMapper.toDTO(clientRepository.save(clientMapper.toEntity(client)));
    }
}
