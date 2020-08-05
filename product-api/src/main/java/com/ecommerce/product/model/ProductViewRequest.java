package com.ecommerce.product.model;

import javax.validation.constraints.NotBlank;

public class ProductViewRequest {
    @NotBlank
    private Long productId;

    public ProductViewRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
