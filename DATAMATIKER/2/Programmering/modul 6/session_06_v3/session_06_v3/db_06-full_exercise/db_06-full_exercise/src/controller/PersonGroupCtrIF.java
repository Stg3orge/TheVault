package controller;

import java.sql.SQLException;
import java.util.List;

import db.HorribleException;
import model.Group;
import model.Person;

public interface PersonGroupCtrIF {

	List<Person> showPersons() throws HorribleException;

	Person pickPerson(int id) throws HorribleException;

	List<Group> showGroups() throws HorribleException;

	void pickNewGroup(int gid) throws HorribleException;

}