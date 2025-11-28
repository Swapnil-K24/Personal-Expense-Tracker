package com.project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	List<Expense> findByDateBetween(LocalDate start, LocalDate end);
	
}
