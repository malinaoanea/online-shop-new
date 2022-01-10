package com.example.onlineshopnew.repository;

import com.example.onlineshopnew.model.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LotRepository extends JpaRepository<Lot, Long> {

    @Query(value = "select number from loturi where product_id = :id", nativeQuery = true)
    int getNumberofProductItems(long id);

    @Query(value = "select * from loturi where nume_lot =:nume", nativeQuery = true)
    Optional<Lot> findByName(String nume);
}
