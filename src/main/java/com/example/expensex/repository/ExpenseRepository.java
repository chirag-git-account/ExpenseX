package com.example.expensex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expensex.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Page<Expense> findByUserId(Long userId, Pageable pageable);

    Page<Expense> findByUserIdAndCategoryId(
            Long userId,
            Long categoryId,
            Pageable pageable
    );

    Page<Expense> findByUserIdAndExpenseDateBetween(
            Long userId,
            java.time.LocalDate from,
            java.time.LocalDate to,
            Pageable pageable
    );

    Page<Expense> findByUserIdAndCategoryIdAndExpenseDateBetween(
            Long userId,
            Long categoryId,
            java.time.LocalDate from,
            java.time.LocalDate to,
            Pageable pageable
    );
}