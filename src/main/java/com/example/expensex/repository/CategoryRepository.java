package com.example.expensex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expensex.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}