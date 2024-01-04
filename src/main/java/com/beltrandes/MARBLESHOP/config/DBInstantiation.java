package com.beltrandes.MARBLESHOP.config;

import com.beltrandes.MARBLESHOP.domain.Client;
import com.beltrandes.MARBLESHOP.repositories.ClientRepository;
import com.beltrandes.MARBLESHOP.utils.mappers.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DBInstantiation implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public void run(String... args) throws Exception {
        clientRepository.deleteAll();

        var client1 = new Client(null, "Beltrandes Marques", "(11) 98953-5288", "beltrandes@gmail.com", "Rua Tripuí, 181");
        var client2 = new Client(null, "Gianlucca Persiani", "(11) 95389-8852", "gianlucca@gmail.com", "Rua Bom Pastor, 425");

        clientRepository.saveAll(Arrays.asList(client1, client2));
    }
}
