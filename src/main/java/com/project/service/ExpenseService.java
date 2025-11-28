package com.project.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Expense;
import com.project.repository.ExpenseRepository;

@Service
public class ExpenseService {
    @Autowired private ExpenseRepository expenseRepo;

    public List<Expense> getAllExpenses() {
        return expenseRepo.findAll();
    }

    public Expense addExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepo.deleteById(id);
    }
    
    public List<Expense> getExpensesBetweenDates(LocalDate start, LocalDate end) {
        return expenseRepo.findByDateBetween(start, end);
    }
}

