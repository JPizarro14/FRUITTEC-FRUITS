package com.aisatec.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aisatec.dao.FruitDAO;
import com.aisatec.model.Fruit;
import com.aisatec.service.FruitService;

@Service
public class FruitServiceImpl implements FruitService {

	@Autowired
	private FruitDAO fruitDAO;

	@Transactional(readOnly = true)
	public List<Fruit> list() {
		Iterable<Fruit> iterable = null;
		iterable = fruitDAO.findAll();
		return (iterable != null ? StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList()) : null);
	}

	@Transactional(readOnly = true)
	public Fruit get(Long id) {
		Fruit model = null;
		model = fruitDAO.findById(id).get();
		return model;
	}

	@Transactional
	public void save(Fruit fruit) {
		fruitDAO.save(fruit);
	}

	@Transactional
	public void delete(Long id) {
		fruitDAO.deleteById(id);
	}
	
	@Transactional
	public void update(Fruit fruitReq, Long id) {
		Fruit fruit = fruitDAO.findById(id).get();

		if (fruit != null) {
			fruit.setFruitName(fruitReq.getFruitName());
		}
		fruitDAO.save(fruit);
	}
	
	@Transactional(readOnly = true)
	public Fruit findByFruitName(String fruitName) {
		Fruit fruit = fruitDAO.findByFruitname(fruitName);
		return fruit;
	}

}
