package com.example.springbootproductmanagement.service.product;

import com.example.springbootproductmanagement.model.Product;
import com.example.springbootproductmanagement.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
