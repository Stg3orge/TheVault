package db;

import java.util.List;

import model.Group;

public interface GroupDBIF {
	List<Group> findAll() throws HorribleException;
	Group findById(int id) throws HorribleException;


}

