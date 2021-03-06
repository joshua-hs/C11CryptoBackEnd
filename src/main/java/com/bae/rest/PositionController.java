package com.bae.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.domain.Position;
import com.bae.service.PositionService;

@RestController
@CrossOrigin
public class PositionController {
	
	private PositionService service;
	
	public PositionController(PositionService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getPositions")
	public ResponseEntity<List<Position>> getPositions() {
		return ResponseEntity.ok(this.service.getPositions());
	}
	
	@PostMapping("/createPosition")
	public ResponseEntity<Position> createPosition(@RequestBody Position position) {
		return new ResponseEntity<Position>(this.service.createPosition(position), HttpStatus.CREATED);
	}
	
	@PutMapping("/increasePosition/{id}")
	public Position increasePosition(@PathVariable Long id, @RequestBody Position newPosition) {
		return this.service.increasePosition(id, newPosition);
	}
	
	@PutMapping("/decreasePosition/{id}")
	public Position decreasePosition(@PathVariable Long id, @RequestBody Position newPosition) {
		return this.service.decreasePosition(id, newPosition);
	}
	
	@DeleteMapping("/removePosition/{id}")
	public boolean removePosition(@PathVariable Long id) {
		return this.service.removePosition(id);
	}
	
}