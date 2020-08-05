package com.ecommerce.product.api;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.ProductCreateRequest;
import com.ecommerce.product.model.ProductCreateResponse;
import com.ecommerce.product.model.ProductViewRequest;
import com.ecommerce.product.model.ProductViewResponse;
import com.ecommerce.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductAPIImpl implements ProductAPI {

    @Autowired
    private ProductService productService;

    @Override
    public ProductViewResponse viewProduct(ProductViewRequest request) {
        Long id = request.getProductId();

        Product product = productService.getProduct(id);
        ProductViewResponse response = new ProductViewResponse();
        response.setProduct(product);
        return response;
    }

    @Override
    public ProductCreateResponse createProduct(ProductCreateRequest request) {
        Product p = request.getProduct();
        p.setId(null);
        Long id = productService.insertProduct(p);

        ProductCreateResponse response = new ProductCreateResponse();
        response.setSuccess(id != null);
        response.setId(id);
        return response;
    }
}
