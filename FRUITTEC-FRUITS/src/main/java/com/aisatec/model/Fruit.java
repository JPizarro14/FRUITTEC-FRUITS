package com.aisatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "FRUIT")
public class Fruit {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "fruitId", required = true)
	@NotNull
	private long fruitId;
	
	@Column(name = "NAME", nullable = false, unique = true)
	@ApiModelProperty(notes = "Fruit Name", required = true)
	@NotNull
	private String fruitname;
	
	public Fruit() {
		super();
	}
	
	public Fruit(Long fruitId, String fruitName) {
		this.fruitId = fruitId;
		this.fruitname = fruitName;
	}

	public Long getId() {
		return fruitId;
	}

	public void setId(Long fruitId) {
		this.fruitId = fruitId;
	}

	public String getFruitName() {
		return fruitname;
	}

	public void setFruitName(String fruitName) {
		this.fruitname = fruitName;
	}
	
	
	
}
