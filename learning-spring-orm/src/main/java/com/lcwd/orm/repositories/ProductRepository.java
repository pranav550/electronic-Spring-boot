package com.lcwd.orm.repositories;

import com.lcwd.orm.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,String> {

    // 1.custom (finder) method
       // Product findByProductName(String productName);
       // Optional<Product> findByProductName(String productName, Sort sort);
        Optional<Product> findByProductName(String productName);
        Product findBypId(String pId);
        //Product findByProductNameIs(String productName);
        //Product findByProductNameEquals(String productName);
        Product findByProductNameIsNot(String productName);
        List<Product> findByProductNameIsNull(String productName, Pageable pageable);

    List<Product> findByActiveTrue();
    List<Product> findByActiveFalse();

    List<Product> findByProductNameStartingWith(String prefix);
    List<Product> findByProductNameEndingWith(String suffix);
    List<Product> findByProductNameContaining(String infix);

    String pattern="Samsung%";
    List<Product> findByProductNameLike(String pattern);

    List<Product> findByPriceLessThan(double price);
    List<Product> findByPriceLessThanEqual(double price);
    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByProductNameIn(Collection<String> names);

    List<Product> findByProductNameAndPrice(String name, double price);
    List<Product> findByProductNameOrPrice(String name, double price);

    List<Product> findByProductNameOrderByProductNameAsc(String productName);

    List<Product> findByProductNameOrderByProductNameDesc(String productName);

    // 2.query methods

    //select all products from query
    //JPQL:
    @Query(value = "SELECT p FROM Product p")
    List<Product> getAllProducts();

    @Query("SELECT p FROM Product p WHERE p.productName='Iphone 14 max pro'")
    List<Product> getAllActiveProducts();

    @Query("SELECT p FROM Product p WHERE p.productName='Samsung S22' AND p.active=1")
    List<Product> getCustomActiveProducts();

    @Query("SELECT p FROM Product p WHERE p.pId=?1 AND p.productName=?2")
    Product getSingleProductByIdAndName1(String pId,String productName);

    @Query("SELECT p FROM Product p WHERE p.pId=:productId AND p.productName=:productName")
    Product getSingleProductByIdAndName2(@Param("productId") String productId, @Param("productName") String productName);

    //@Modifying used  for update query

    // native queries

    @Query(value = "select * from jpa_product where product_name=:productName", nativeQuery = true)
    Product getProductByIdAndNameNative(@Param("productName") String productName);

}
