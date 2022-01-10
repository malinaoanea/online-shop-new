package com.example.onlineshopnew.repository;

import com.example.onlineshopnew.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select count(*) > 0 from users where email =:email", nativeQuery = true)
    boolean emailExists(String email);

    @Query(value =  "SELECT id from users where email = :email", nativeQuery = true)
    long getId(String email);

    @Query(value = "SELECT * from users", nativeQuery = true)
    List<User> getAll();

    @Modifying
    @Query(value = "update users set usertype= :type where email = :email", nativeQuery = true)
    public void editType(String email, String type);

    @Query(value = "select * from users where email = :email", nativeQuery = true)
    User getUserWithEmail(String email);


    @Modifying
    @Query(value="INSERT INTO users (email, usertype, surname, name) VALUES (:email, :user_type, :surname, :name)", nativeQuery = true)
    void saveUser(String email, String user_type, String surname, String name);

}
