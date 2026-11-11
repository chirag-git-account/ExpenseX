package com.example.expensex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expensex.entity.IncomeCategory;

public interface IncomeCategoryRepository extends JpaRepository<IncomeCategory, Long> {
}