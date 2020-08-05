package com.ecommerce.project.service;

import com.ecommerce.product.api.ProductAPIImpl;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductService;
import com.ecommerce.product.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Product.class})
public class ProductConfiguration {

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }

    @Bean
    public ProductAPIImpl getProductAPIImpl() {
        return new ProductAPIImpl();
    }


}
