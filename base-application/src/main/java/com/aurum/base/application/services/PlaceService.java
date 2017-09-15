package com.aurum.base.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurum.base.application.dao.PlaceDAO;
import com.aurum.base.model.entities.Place;

@Service
public class PlaceService {
	@Autowired
	private PlaceDAO places;
	
	public void addPlace(Place place){
		places.save(place);
	}
	
	public Place getByID(Long id){
		return places.findOne(id);
	}
	
	public Iterable<Place> getList(){
		return places.findAll();
	}
	
	public Place getByName(String name){
		return places.findByName(name);
	}

	public Iterable<Place> search(String nameToSearch) {
		return places.searchByName("%" + nameToSearch +"%");
	}
	public void deletePlace(Long id){
		places.delete(id);
	}
}
