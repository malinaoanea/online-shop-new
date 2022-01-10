package com.example.onlineshopnew.repository;

import com.example.onlineshopnew.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {

    @Modifying
    @Query(value = "INSERT INTO comenzi (cart_id, user_id, total_price) VALUES (:cart_id, :user_id, :total)", nativeQuery = true)
    public void addComanda(long cart_id, long user_id, int total);
}

