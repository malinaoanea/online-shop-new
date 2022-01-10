package com.example.onlineshopnew.repository;

import com.example.onlineshopnew.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from products", nativeQuery = true)
    List<Product> getAll();
    @Query(value = "select * from products where category_id = :id", nativeQuery = true)
    List<Product> getProductByCategory(long id);

    @Query(value = "select price from products where id = :id", nativeQuery = true)
    int getPrice(int id);

    @Modifying
    @Query(value = "INSERT INTO products (price, name, category_id, lot_id) VALUES (:price, :name, :category_id, :lot_id)", nativeQuery = true)
    public void addComanda(long price, String name, long category_id, long lot_id);

    Optional<Product> findByName(String name);

}
