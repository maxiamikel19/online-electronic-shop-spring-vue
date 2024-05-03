package com.maxi.apionlineshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maxi.apionlineshop.models.User;
import com.maxi.apionlineshop.models.enums.Role;

public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User set role = :role where username = :username")
    void changeTheUserRole(@Param("username") String username, @Param("role") Role role);
}
