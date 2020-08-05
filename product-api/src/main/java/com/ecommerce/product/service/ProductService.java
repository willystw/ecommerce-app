package com.ecommerce.product.service;

import com.ecommerce.product.model.Product;

public interface ProductService {
    Product getProduct(long id);

    Long insertProduct(Product product);
}
