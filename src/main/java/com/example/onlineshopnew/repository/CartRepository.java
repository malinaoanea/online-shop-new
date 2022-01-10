package com.example.onlineshopnew.repository;

import com.example.onlineshopnew.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query(value = "select id from carts where user_id = :user_id", nativeQuery = true)
    public long getCartId(Long user_id);

    @Modifying
    @Query(value="INSERT INTO carts (user_id) VALUES (:user_id)", nativeQuery = true)
    public void addCart(long user_id);

    @Query(value = "SELECT COUNT(*) > 0 FROM carts pk WHERE pk.user_id=:user_id", nativeQuery = true)
    public boolean userHasCart(long user_id);

    @Query(value = "SELECT count(*) > 0 from carts where id = :id", nativeQuery = true)
    public boolean cartExists(long id);
}
