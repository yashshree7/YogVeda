package com.yogveda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yogveda.model.YogaPose;
import com.yogveda.repository.YogaPoseDAO;

@Service
public class YogaPoseService {

	private final YogaPoseDAO dao;
	
	public YogaPoseService(YogaPoseDAO dao) {
		this.dao = dao;
	}
	
	public List<YogaPose> getAll(){
		return dao.findAll();
	}
	
	public Optional<YogaPose> getById(Long id){
		return dao.findById(id);
	}
	
	public void create(YogaPose pose) {
		dao.insert(pose);
	}
	
	public boolean update(Long id, YogaPose pose) {
		return dao.update(id, pose) > 0;
	}
	
	public boolean delete(Long id) {
		return dao.delete(id) > 0;
	}
}
