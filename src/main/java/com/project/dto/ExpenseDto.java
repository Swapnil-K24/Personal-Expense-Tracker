package com.project.dto;

import java.time.LocalDate;

public class ExpenseDto {
	private Long id;
    private String description;
    private double amount;
    private LocalDate date;
    private Long categoryId;
	public ExpenseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpenseDto(Long id, String description, double amount, LocalDate date, Long categoryId) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.categoryId = categoryId;
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
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
    
    
}
