package com.brij.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product-client", url = "${productUrl}")
public interface ProductClient {

    @GetMapping(
            value = "/products/{id}",
            headers = {"Accept= application/json"})
    Product getProductById(@PathVariable("id") Long id);



}
