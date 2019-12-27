package com.aisatec.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aisatec.model.Fruit;

@Repository
public interface FruitDAO extends CrudRepository<Fruit, Long> {

	Fruit findByFruitname(String fruitName);
	
}
