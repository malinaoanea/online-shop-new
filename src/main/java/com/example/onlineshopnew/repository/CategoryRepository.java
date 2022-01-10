package com.example.onlineshopnew.repository;

import com.example.onlineshopnew.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select category_name from categories", nativeQuery = true)
    List<String> getCategories();

    @Query(value = "select id from categories where category_name = :category", nativeQuery = true)
    Long getPr(String category);

    @Query(value = "select count(*) > 0 from categories where category_name =:nume", nativeQuery = true)
    boolean categExists(String nume);

}

