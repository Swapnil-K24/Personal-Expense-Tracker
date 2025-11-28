package com.project.dto;

public class CategoryDto {
	private Long id;
    private String name;
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
    
    
}
