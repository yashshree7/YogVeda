package com.yogveda.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogveda.model.YogaPose;
import com.yogveda.service.YogaPoseService;

@RestController
@RequestMapping("/api/yoga")
public class YogaPoseController {
	
	private final YogaPoseService service;
	
	public YogaPoseController(YogaPoseService service) {
		this.service = service;
	}
	
	//GET all poses
	@GetMapping("/poses")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	//GET by id
	@GetMapping("/poses/{id}")
	public ResponseEntity<YogaPose> getById(@PathVariable Long id){
		return service.getById(id).map(ResponseEntity::ok) .orElse(ResponseEntity.notFound().build());
	}
	
	//CRUD OPERATION
	
	//CREATE
	@PostMapping("/poses")
	public ResponseEntity<Void> create(@RequestBody YogaPose pose){
		service.create(pose);
		return ResponseEntity.created(URI.create("/api/yoga/poses")).build();
	}
	
	// UPDATE
    @PutMapping("/poses/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody YogaPose pose) {
        boolean updated = service.update(id, pose);
        return updated ? ResponseEntity.noContent().build()
                       : ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/poses/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted ? ResponseEntity.noContent().build()
                       : ResponseEntity.notFound().build();
    }
}
