package com.beltrandes.MARBLESHOP.config;

import com.beltrandes.MARBLESHOP.domain.Client;
import com.beltrandes.MARBLESHOP.domain.Product;
import com.beltrandes.MARBLESHOP.domain.Quotation;
import com.beltrandes.MARBLESHOP.domain.QuoteItem;
import com.beltrandes.MARBLESHOP.repositories.ClientRepository;
import com.beltrandes.MARBLESHOP.repositories.ProductRepository;
import com.beltrandes.MARBLESHOP.repositories.QuotationRepository;
import com.beltrandes.MARBLESHOP.repositories.QuoteItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DBInstantiation implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private QuotationRepository quotationRepository;
    @Autowired
    private QuoteItemRepository quoteItemRepository;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        clientRepository.deleteAll();
        productRepository.deleteAll();
        quotationRepository.deleteAll();
        quoteItemRepository.deleteAll();

        var product1 = new Product(null, "Preto São Gabriel", "Granito", "Preto", "Granulado", null, 950.00, null);
        var product2 = new Product(null, "Branco Prime", "Silestone", "Branco", "Liso", null, 1200.00, null);

        productRepository.saveAll(Arrays.asList(product1, product2));

        var client1 = new Client(null, "Beltrandes Marques", "(11) 98953-5288", "beltrandes@gmail.com", "Rua Tripuí, 181", null);
        var client2 = new Client(null, "Gianlucca Persiani", "(11) 95389-8852", "gianlucca@gmail.com", "Rua Bom Pastor, 425", null);

        clientRepository.saveAll(Arrays.asList(client1, client2));

        var quotation1 = new Quotation(null, null, 15, null, client1, null, null, null);
        var quotation2 = new Quotation(null, null, 20, null, client2, null, null, null);
        quotation1.setDate(LocalDateTime.now());
        quotation1.calculateDeadlineDate();
        quotation2.setDate(LocalDateTime.now());
        quotation2.calculateDeadlineDate();
        quotationRepository.saveAll(Arrays.asList(quotation1, quotation2));

        client1.setQuotations(Arrays.asList(quotation1));
        client2.setQuotations(Arrays.asList(quotation2));


        var quoteItem1 = new QuoteItem(null, "Bancada cozinha", 1.95, 0.65, 2, product1, quotation1);
        quoteItem1.calculateM2();
        quoteItem1.calculateValue();
        quoteItem1.calculateTotalM2();
        quoteItem1.calculateTotalValue();
        var quoteItem2 = new QuoteItem(null, "Lavatório banheiro", 1.20, .50, 1, product2, quotation1);
        quoteItem2.calculateM2();
        quoteItem2.calculateValue();
        quoteItem2.calculateTotalM2();
        quoteItem2.calculateTotalValue();
        var quoteItem3 = new QuoteItem(null, "Bancada cozinha", 2.36, .60, 1, product2, quotation2);
        quoteItem3.calculateM2();
        quoteItem3.calculateValue();
        quoteItem3.calculateTotalM2();
        quoteItem3.calculateTotalValue();


        quoteItemRepository.saveAll(Arrays.asList(quoteItem1, quoteItem2, quoteItem3));

        quotation1.setItems(Arrays.asList(quoteItem1, quoteItem2));
        quotation1.calculateTotalM2();
        quotation1.calculateTotalValue();
        quotation2.setItems(List.of(quoteItem3));
        quotation2.calculateTotalM2();
        quotation2.calculateTotalValue();




    }
}
