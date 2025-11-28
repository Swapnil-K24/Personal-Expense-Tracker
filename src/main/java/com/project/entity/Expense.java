package com.project.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {
    @Id @GeneratedValue
    private Long id;
    private String description;
    private double amount;
    private LocalDate date;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expense(Long id, String description, double amount, LocalDate date, Category category, User user) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.category = category;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
}
