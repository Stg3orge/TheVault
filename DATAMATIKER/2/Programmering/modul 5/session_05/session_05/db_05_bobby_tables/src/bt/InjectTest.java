package bt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InjectTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=school;user=sa;password=secret");
		System.out.println("connected");
		
		// Just test the query
		Statement s = con.createStatement();
		s.executeUpdate("insert into students values('Nerdy Mom', '2008-08-08', '314314314', 'Bobby Tables');");
		ResultSet rs = s.executeQuery("select * from students");
		displayResultSet(rs);
		rs.close();
		
		// Test with a parametrized update
		String name = "Robert Tables";
		s.executeUpdate("insert into students values('Nerdy Mom', '2008-08-08', '314314314', '" + name + "');");
		rs = s.executeQuery("select * from students");
		displayResultSet(rs);
		rs.close();
		
		// Test with the full name of "Robert"
		name = "Robert'); drop table students; --";
		s.executeUpdate("insert into students values('Nerdy Mom', '2008-08-08', '314314314', '" + name + "');");
		rs = s.executeQuery("select * from students");
		displayResultSet(rs);
		rs.close();
		
		s.close();
		con.close();
	}
	
	private static void displayResultSet(ResultSet rs) throws SQLException {
		while(rs.next()) {
			int colCount = rs.getMetaData().getColumnCount();
			String output = "";
			for(int i = 1; i <= colCount; i++){
				output += rs.getString(i) + "\t";
			}
			System.out.println(output);
		}
		System.out.println("-----------------------------------------------------------------");

	}
}
