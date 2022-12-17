package com.example.springdemo.repository;

import com.example.springdemo.model.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemoRepository extends JpaRepository<Demo, Long> {
    Demo findById(long id);
    Demo deleteById(long id);
    Demo findByName(String name);
}
