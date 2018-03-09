package controller;

import java.sql.SQLException;
import java.util.List;

import db.DogDB;
import model.Dog;

public class DogController {
	private DogDB dogDB = new DogDB();
	public Dog create(String name, int feeYear, int memberId, int breedId) throws SQLException {
		return dogDB.create(name, feeYear, memberId, breedId);
	}
	
	public boolean delete(int id) throws SQLException {
		return dogDB.delete(id);
	}
	
	public List<Dog> findAll() throws SQLException {
		return dogDB.findAll();
	}
	
	public Dog findById(int id) throws SQLException {
		return dogDB.findById(id, true);
	}
	public List<Dog> findByName(String name) throws SQLException {
		return dogDB.findByName(name);
	}
	
	public List<Dog> findByOwner(int ownerId) throws SQLException {
		return dogDB.findByMemberId(ownerId);
	}
	
	public Dog updte(int id, String name, int feeYear, int memberId, int breedId) throws SQLException {
		return dogDB.update(id, name, feeYear, memberId, breedId);
	}
	
}
