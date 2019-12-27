package com.aisatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisatec.model.Fruit;
import com.aisatec.service.FruitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/Fruit")
@Api (value = "Fruits Microservice", description = "This API has a CRUD for fruits")
public class FruitController {

	@Autowired
    private FruitService fruitService;
	
	@GetMapping("/fruits")
	@ApiOperation(value = "Find all fruits", notes ="Returns all fruits")
	public List getFruits() {
		return fruitService.list();
	}

	@GetMapping("/fruit/{id}")
	@ApiOperation(value = "Find a fruit", notes ="Returns a fruit by Id")
	public ResponseEntity getFruit(@PathVariable("id") Long id) {
		Fruit fruit = null;
		fruit = fruitService.get(id);
		if (fruit == null) {
			return new ResponseEntity("No fruit found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(fruit, HttpStatus.OK);
	}
	
	@GetMapping("/fruitName/{fruitName}")
	@ApiOperation(value = "Find a fruit", notes ="Returns a fruit by FruitName")
	public ResponseEntity findByFruitName(@PathVariable("fruitName") String fruitName) {
		Fruit fruit = null;
		fruit = fruitService.findByFruitName(fruitName);
		if (fruit == null) {
			return new ResponseEntity("No fruit found for name " + fruitName, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(fruit, HttpStatus.OK);
	}

	@PostMapping(value = "/fruit")
	@ApiOperation(value = "Create a fruit", notes ="Returns a new fruit")
	public ResponseEntity createFruit(@RequestBody Fruit fruit) {
		fruitService.save(fruit);
		return new ResponseEntity(fruit, HttpStatus.OK);
	}

	@DeleteMapping("/fruit/{id}")
	@ApiOperation(value = "Delete a fruit", notes ="Returns deleted fruits id")
	public ResponseEntity deleteFruit(@PathVariable Long id) {
		fruitService.delete(id);
		return new ResponseEntity(id, HttpStatus.OK);
	
	}

	@PutMapping("/fruit/{id}")
	@ApiOperation(value = "Update a fruit", notes ="Returns updated fruit")
	public ResponseEntity updateFruit(@RequestBody Fruit fruit) {
		fruitService.save(fruit);
		return new ResponseEntity(fruit, HttpStatus.OK);
	}

}