package com.example.expensex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.expensex.entity.Income;

import java.time.LocalDate;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    Page<Income> findByUserId(Long userId, Pageable pageable);

    Page<Income> findByUserIdAndIncomeCategoryId(
            Long userId,
            Long categoryId,
            Pageable pageable
    );

    Page<Income> findByUserIdAndIncomeDateBetween(
            Long userId,
            LocalDate from,
            LocalDate to,
            Pageable pageable
    );

    Page<Income> findByUserIdAndIncomeCategoryIdAndIncomeDateBetween(
            Long userId,
            Long categoryId,
            LocalDate from,
            LocalDate to,
            Pageable pageable
    );
}