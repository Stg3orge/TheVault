package Ctr;

import Db.*;
import Model.*;

public class PersonCtr {
	private PersonDb dbPer;
	
	public PersonCtr()
	{		
		dbPer = new PersonDb();
	}	
	
	public int insertPerson(String name)
	{	
		/*------------------------------
		 *------------------------------
		//Create the appropriate code to insert a person in the Db 
		//Change the dummy value in the return value
		//Think coupling, cohesion and creator pattern
		 * -----------------------------
		 * -----------------------------*/				
		
		return 0;
	}
	
	public Person getPerson(int id)
	{		
		return dbPer.getPerson(id);	
	}	
	
}
