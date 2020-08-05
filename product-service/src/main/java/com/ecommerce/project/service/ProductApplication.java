package com.ecommerce.project.service;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EntityScan(basePackageClasses = {Product.class})
@EnableJpaRepositories(basePackageClasses = {ProductRepository.class})
public class ProductApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ProductApplication.class);

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Start Application");

        Product p = new Product();
        p.setStoreName("tokopedia");
        p.setPrice(95000L);

        Product p2 = new Product();
        p2.setStoreName("store12");
        p2.setPrice(10000L);

        productRepository.save(p);
        productRepository.save(p2);

        System.out.println("\nfindAll()");
        productRepository.findAll().forEach(x -> System.out.println(x));

    }

}
