package controller;

import java.util.List;

import db.HorribleException;
import model.Group;

public interface GroupCtrIF {

	List<Group> findAll() throws HorribleException;

	Group findById(int id) throws HorribleException;

}