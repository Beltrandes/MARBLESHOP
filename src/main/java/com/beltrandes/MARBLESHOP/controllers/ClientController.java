package com.beltrandes.MARBLESHOP.controllers;

import com.beltrandes.MARBLESHOP.dtos.ClientDTO;
import com.beltrandes.MARBLESHOP.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.ok().body(clientService.findAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(clientService.findClientById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO client) {
        client = clientService.insertClient(client);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable String id, @RequestBody ClientDTO client) {
        return ResponseEntity.ok().body(clientService.updateClient(id, client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
