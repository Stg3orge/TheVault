package Db;

import java.sql.*;

public class DbConnection {

	//Constants used to get access to the database
	private static final String  driver = "jdbc:sqlserver://localhost:1433";
	private static final String  databaseName = ";databaseName=Patterns";
	
	/*------------------------------
	 *------------------------------
	//Consider security issues in relation to use 'mixed mode' authentication on your SQL server 
	 * -----------------------------
	 * -----------------------------*/
	private static String  userName = "; user=sa";
	private static String password = ";password=1234";


	private DatabaseMetaData dma;
	private static Connection con;
	// an instance of the class is generetated
	private static DbConnection  instance = null;

	// the constructor is private to ensure that only one object of this class is created
	private DbConnection()
	{
		String url = driver + databaseName + userName + password;

		try{
			//load of driver			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Load af class ok");

		}
		catch(Exception e){
			System.out.println("Can not find the driver");
			System.out.println(e.getMessage());
		}//end catch
		try{	
			con = DriverManager.getConnection(url);
			con.setAutoCommit(true);
			dma = con.getMetaData(); 
			System.out.println("Connection to " + dma.getURL());
			System.out.println("Driver " + dma.getDriverName());
			System.out.println("Database product name " + dma.getDatabaseProductName());
		}//end try
		catch(Exception e){

			System.out.println("Problems with the connection to the database");
			System.out.println(e.getMessage());
			System.out.println(url);
		}//end catch
	}//end  constructor

	//closeDb: closes the connection to the database
	public static void closeConnection()
	{
		try {
			if (con != null)
			{
				con.close();
			}
			System.out.println("The connection is closed");
		}				
		catch (Exception e) 
		{
			System.out.println("Error trying to close the database " +  e.getMessage());
		};
	}

	//getDBcon: Get-method, returns the connection to the database
	public  Connection getDBcon()
	{
		return con;
	}
	//this method is used to get the instance of the connection
	public static DbConnection getInstance()
	{
		if (instance == null)
		{
			instance = new DbConnection();
		}
		return instance;
	}	    
}//end DbConnection




