package com.project.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Expense> expenses;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, String name, User user, List<Expense> expenses) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.expenses = expenses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
    
    
}
