package com.rk.Category.Service.Modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable  = false)
	private String name;
	
	
	private String image;
	@Column(nullable  = false)
	private Long salonId;
	
	public Category() {
		
	}

	public Category(Long id, String name, String image, Long salonId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.salonId = salonId;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getSalonId() {
		return salonId;
	}

	public void setSalonId(Long salonId) {
		this.salonId = salonId;
	}
	
	
	
	
	

}
