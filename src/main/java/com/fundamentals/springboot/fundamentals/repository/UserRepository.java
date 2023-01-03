package com.fundamentals.springboot.fundamentals.repository;

import com.fundamentals.springboot.fundamentals.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
