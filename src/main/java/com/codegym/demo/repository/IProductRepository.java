package com.codegym.demo.repository;

import com.codegym.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

    //Tìm kiếm sản phẩm theo tên
    @Query(value = "select * from product where product.name like ?", nativeQuery = true)
    Page<Product> findProductByName(String name, Pageable pageable);

    //Tìm kiếm sản phẩm theo category
    @Query(value = "select * from product where product.category_id = ?", nativeQuery = true)
    Page<Product> findProductByCategoryName(Long id, Pageable pageable);

    //Top5 Product Newest
    Page<Product> findTop5ByOrderByDateTimeDesc(Pageable pageable);

//    @Query(value = "select * from product order by date desc limit ?", nativeQuery = true)
//    List<Product> findTop5ByOrderByDatetimeDesc(int number);

    //Top5 price max
    Page<Product> findTop5ByOrderByPriceDesc(Pageable pageable);

//    @Query(value = "select * from product order by price desc limit ?", nativeQuery = true)
//    List<Product> findTop5ByOrderByPriceDesc(int number);

    // Tinh tổng tiền
    @Query(value = "select sum(price * quantity) from Product ")
    long sumPrice();

}
