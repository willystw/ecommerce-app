package com.ecommerce.product.model;

import javax.validation.constraints.NotNull;

public class ProductCreateRequest {
    @NotNull
    private Product product;

    public ProductCreateRequest() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
