package db;

import java.sql.SQLException;

import model.Dog;

public interface DogDBIF {
	Dog findById(int id, boolean retrieveAssociation) throws SQLException;
	// TODO: Add more methods
}
