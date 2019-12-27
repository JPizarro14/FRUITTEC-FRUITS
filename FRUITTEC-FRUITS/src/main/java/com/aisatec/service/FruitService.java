package com.aisatec.service;

import java.util.List;

import com.aisatec.model.Fruit;

public interface FruitService {
	List<Fruit> list();
	Fruit get(Long id);
	void save(Fruit message);
	void delete(Long id);	
	Fruit findByFruitName(String fruitName);
}
