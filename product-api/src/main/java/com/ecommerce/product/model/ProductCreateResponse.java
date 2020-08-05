package com.ecommerce.product.model;

public class ProductCreateResponse {
    private boolean isSuccess;
    private Long id;

    public ProductCreateResponse() {
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
