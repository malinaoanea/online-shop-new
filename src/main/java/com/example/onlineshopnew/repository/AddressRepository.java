package com.example.onlineshopnew.repository;

import com.example.onlineshopnew.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "select adress from adresses where user_id = :id", nativeQuery = true)
    String getAdressOfClient(int id);
}
