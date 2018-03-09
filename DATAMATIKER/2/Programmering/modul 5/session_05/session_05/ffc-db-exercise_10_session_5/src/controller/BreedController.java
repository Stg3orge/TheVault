package controller;

import java.sql.SQLException;
import java.util.List;

import db.BreedDB;
import model.Breed;

public class BreedController {
	public Breed create(String name, String description, int maxWeight) throws SQLException {
		Breed res = new Breed(name, maxWeight, description);
		res = new BreedDB().create(res);
		return res;
	}
	public boolean delete(int id) throws SQLException {
		Breed breed = new Breed();
		breed.setId(id);
		return new BreedDB().delete(breed); 
	}
	
	public Breed update(Breed breed) throws SQLException {
		return new BreedDB().update(breed);
	}
	public List<Breed> findAll() throws SQLException {
		return new BreedDB().getAll();
	}
	public Breed findById(int id) throws SQLException {
		return new BreedDB().findById(id);
	}
	public List<Breed> findByName(String name) throws SQLException {
		return new BreedDB().findByName(name);
	}
}
