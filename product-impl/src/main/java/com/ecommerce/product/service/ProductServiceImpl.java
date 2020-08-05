package com.ecommerce.product.service;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Long insertProduct(Product product) {
        Product id = productRepository.save(product);
        return id.getId();
    }
}
