package com.aloyolaa.dtodemo.repository;

import com.aloyolaa.dtodemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}