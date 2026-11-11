package com.example.expensex.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.expensex.entity.Expense;
import com.example.expensex.entity.User;
import com.example.expensex.exception.ResourceNotFoundException;
import com.example.expensex.repository.ExpenseRepository;
import com.example.expensex.repository.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(
            ExpenseRepository expenseRepository,
            UserRepository userRepository) {

        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public Page<Expense> getExpenses(
            String email,
            Long categoryId,
            LocalDate from,
            LocalDate to,
            Pageable pageable) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Long userId = user.getId();

        if (categoryId != null && from != null && to != null) {

            return expenseRepository
                    .findByUserIdAndCategoryIdAndExpenseDateBetween(
                            userId,
                            categoryId,
                            from,
                            to,
                            pageable
                    );

        } else if (categoryId != null) {

            return expenseRepository
                    .findByUserIdAndCategoryId(
                            userId,
                            categoryId,
                            pageable
                    );

        } else if (from != null && to != null) {

            return expenseRepository
                    .findByUserIdAndExpenseDateBetween(
                            userId,
                            from,
                            to,
                            pageable
                    );
        }

        return expenseRepository.findByUserId(
                userId,
                pageable
        );
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense createExpense(
            Expense expense,
            String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public Optional<Expense> updateExpense(
            Long id,
            Expense updatedExpense,
            String email) {

        return expenseRepository.findById(id)
                .filter(expense ->
                        expense.getUser()
                                .getEmail()
                                .equals(email))
                .map(existingExpense -> {

                    existingExpense.setCategory(
                            updatedExpense.getCategory());

                    existingExpense.setAmount(
                            updatedExpense.getAmount());

                    existingExpense.setExpenseDate(
                            updatedExpense.getExpenseDate());

                    existingExpense.setExpenseTime(
                            updatedExpense.getExpenseTime());

                    existingExpense.setDescription(
                            updatedExpense.getDescription());

                    existingExpense.setPaymentMethod(
                            updatedExpense.getPaymentMethod());

                    existingExpense.setCurrency(
                            updatedExpense.getCurrency());

                    return expenseRepository.save(existingExpense);
                });
    }

    public boolean deleteExpense(
            Long id,
            String email) {

        return expenseRepository.findById(id)
                .filter(expense ->
                        expense.getUser()
                                .getEmail()
                                .equals(email))
                .map(expense -> {

                    expenseRepository.delete(expense);
                    return true;

                })
                .orElse(false);
    }
}