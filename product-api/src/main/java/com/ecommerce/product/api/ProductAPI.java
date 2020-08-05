package com.ecommerce.product.api;

import com.ecommerce.product.model.ProductCreateRequest;
import com.ecommerce.product.model.ProductCreateResponse;
import com.ecommerce.product.model.ProductViewRequest;
import com.ecommerce.product.model.ProductViewResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public interface ProductAPI {
    @RequestMapping(value = "/view", method = RequestMethod.POST)
    @ResponseBody
    ProductViewResponse viewProduct(@RequestBody @Valid ProductViewRequest request);

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    ProductCreateResponse createProduct(@RequestBody @Valid ProductCreateRequest request);
}
