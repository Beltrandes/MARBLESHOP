package com.beltrandes.MARBLESHOP.config;

import com.beltrandes.MARBLESHOP.domain.Client;
import com.beltrandes.MARBLESHOP.domain.Product;
import com.beltrandes.MARBLESHOP.repositories.ClientRepository;
import com.beltrandes.MARBLESHOP.repositories.ProductRepository;
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
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        clientRepository.deleteAll();
        productRepository.deleteAll();

        var client1 = new Client(null, "Beltrandes Marques", "(11) 98953-5288", "beltrandes@gmail.com", "Rua Tripuí, 181");
        var client2 = new Client(null, "Gianlucca Persiani", "(11) 95389-8852", "gianlucca@gmail.com", "Rua Bom Pastor, 425");

        clientRepository.saveAll(Arrays.asList(client1, client2));

        var product1 = new Product(null, "Preto São Gabriel", "Granito", "Preto", "Granulado", null, 950.00);
        var product2 = new Product(null, "Branco Prime", "Silestone", "Branco", "Liso", null, 1200.00);

        productRepository.saveAll(Arrays.asList(product1, product2));

    }
}
