package com.codegym.demo.service.product;

import com.codegym.demo.model.Product;
import com.codegym.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findProductByName(String name, Pageable pageable) {
        return productRepository.findProductByName(name, pageable);
    }

    @Override
    public Page<Product> findProductByCategoryName(Long id, Pageable pageable) {
        return productRepository.findProductByCategoryName(id, pageable);
    }

    @Override
    public Page<Product> top5ProductPriceMax(Pageable pageable) {
        return productRepository.findTop5ByOrderByPriceDesc(pageable);
    }

    @Override
    public Page<Product> top5ProductNewest(Pageable pageable) {
        return productRepository.findTop5ByOrderByDateTimeDesc(pageable);
    }

    @Override
    public long sumPrice() {
        return productRepository.sumPrice();
    }

}

