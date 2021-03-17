package com.codegym.demo.service.product;

import com.codegym.demo.model.Product;
import com.codegym.demo.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IService<Product> {

    Page<Product> findProductByName(String name, Pageable pageable);

    Page<Product> findProductByCategoryName(Long id, Pageable pageable);

    Page<Product> top5ProductPriceMax(Pageable pageable);

    Page<Product> top5ProductNewest(Pageable pageable);

    long sumPrice();
}
