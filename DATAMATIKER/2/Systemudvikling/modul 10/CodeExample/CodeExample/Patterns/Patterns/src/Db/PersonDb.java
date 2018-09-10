package Db;

import Model.*;
import java.sql.*;

public class PersonDb {
	private  Connection con;
	
	public PersonDb()
	{
		con = DbConnection.getInstance().getDBcon();		
	}
	
	//insert person into Db
	public int insertPerson(Person per)
	{  		
		int resultCount = -1;
		String query="INSERT INTO Person(name) VALUES(?)";

		//using "try-with-resources statement" to make sure that my statement is closed
		try(PreparedStatement stmt=con.prepareStatement(query))
		{	
			stmt.setString(1, per.getName());			

			stmt.setQueryTimeout(5);
			resultCount = stmt.executeUpdate();		
		}
		catch(SQLException ex)
		{				 
			System.out.println(ex+ "Person is not inserted correct");
		}		

		return(resultCount);
	}
	
	
	//get a person from Db
	public Person getPerson(int id)
	{
		ResultSet results;
		
		/*------------------------------
		 *------------------------------
		//Why is the object created here and not in the GUI or controller?
		 * -----------------------------
		 * -----------------------------*/
		Person personObj = new Person();
		String query =  "Select id, name from Person where id = ?";   

		//using "try-with-resources statement" to make sure that my statement and resultset is closed
		try(PreparedStatement stmt=con.prepareStatement(query))
		{ 
			stmt.setInt(1, id);
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery();

			if( results.next() ){
				personObj.setId(Integer.parseInt(results.getString("id")));
				personObj.setName(results.getString("name"));	
			}
			else
			{ 
				personObj = null;
			}			
		}
		catch(Exception e)
		{
			System.out.println("Query exception: "+e);
		}
		
		return personObj;
	}	
}
