package com.example.onlineshopnew.repository;

import com.example.onlineshopnew.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Modifying
    @Query(value = "INSERT INTO cart_items (id_cart, id_product) VALUES (:cart_id, :product_id)", nativeQuery = true)
    public void addCartItem(Long cart_id, Long product_id);

    @Modifying
    @Query(value = "INSERT INTO cart_items (id_cart, id_product) VALUES (:cart_id, :product_id)", nativeQuery = true)
    public void save(Long cart_id, Long product_id);

    @Modifying
    @Query(value = "delete from cart_items where id_cart=:cart_id", nativeQuery = true)
    public void deleteByCartId(long cart_id);

    @Query(value = "select id_product from cart_items where id_cart = :cart_id", nativeQuery = true)
    public List<Integer> getItemsWithCartId(long cart_id);
}
