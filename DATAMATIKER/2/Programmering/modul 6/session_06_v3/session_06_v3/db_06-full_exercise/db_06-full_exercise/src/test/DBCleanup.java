package test;

import java.sql.SQLException;

import db.DBConnection;
/**
 * Utility class used by all the @Before methods in the test suite
 * that access the database. All tables are dropped, re-created and 
 * filled with data. By dropping the table, we reset the auto-generated
 * indices s.t. IDENTITY(1,1) starts on 1 and we can also count on the
 * ids of the records to be the same in all cases.
 * @author knol
 * @version 2017-03-20
 *
 */
public class DBCleanup {
	public static void main(String[] args) throws SQLException {
		cleanDB(); // call to the utility class that resets the database
		System.out.println("cleaned");
	}
	public static void cleanDB() throws SQLException {
		e("drop table persons");
		e("drop table groups");
		for(int i = 0 ; i < script.length; i++) {
			e(script[i]);
		}
	}

	private static void e(String sql) throws SQLException {
		DBConnection.getInstance().getConnection().createStatement().executeUpdate(sql);
	}
	
	private static final String[] script = {
			"create table groups (id int primary key identity(1,1), name varchar(64), description varchar(255))",
			"create table persons (id int primary key identity(1,1),name varchar(50),email varchar(120),phone varchar(25),birth_date date,groups_id int not null foreign key references groups(id) on delete cascade on update cascade)",
			"insert into groups values('friends', 'all my buddies');",
			"insert into groups values('family', 'my dear beloved family');",
			"insert into persons values('Joe', 'joe@email.com', '12121212', '1995-05-05', 1);",
			"insert into persons values('Mom', 'mom@email.com', '1234567', '1965-05-05', 2);",
			"insert into persons values('Dad', 'dad@email.com', '1234567', '1963-03-03', 2);"
	};
}
