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
 * @version 2017-02-20
 *
 */
public class DBCleanup {
	public static void main(String[] args) throws SQLException {
		cleanDB(); // call to the utility class that resets the database
		System.out.println("cleaned");
	}
	public static void cleanDB() throws SQLException {
		e("drop table dog");
		e("drop table member");
		e("drop table breed");
		for(int i = 0 ; i < script.length; i++) {
			e(script[i]);
		}
	}

	private static void e(String sql) throws SQLException {
		DBConnection.getInstance().getConnection().createStatement().executeUpdate(sql);
	}
	
	private static final String[] script = {
		"create table breed(id int primary key identity(1,1), name varchar(20) not null, max_weight int, description varchar(256))",
		"create table member (id int primary key identity(1,1),	name varchar(40) not null, email varchar(40), phone varchar(40))",
		"create table dog (id int primary key identity(1,1),name varchar(20) not null, fee_year int default 0 not null,	breed_id int foreign key references breed(id) on delete set null on update cascade,	member_id int foreign key references member(id) on delete cascade on update cascade)",
		"insert into breed values ('Alaskan Malamute', 39, 'The Alaskan Malamute is a large breed of domestic dog (Canis lupus familiaris) originally bred for hauling heavy freight because of their strength and endurance, and later an Alaskan sled dog.')",
		"insert into breed values ('Norwegian Elkhound', 23, 'The Norwegian Elkhound is one of the ancient Northern Spitz-type breed of dog and is the National Dog of Norway.')",
		"insert into breed values ('Komondor', 60, 'The Komondor (plural komondorok), also known as the Hungarian sheepdog, is a large, white-coloured Hungarian breed of livestock guardian dog with a long, corded coat.')",
		"insert into member values ('Gunnar Kaasen', 'gunnar@alaska.us', '12121212')",
		"insert into dog values ('Balto', 1925, 1, 1)",
		"insert into member values ('Ole Agnar', 'ag-nordm@online.no', '41502799')",
		"insert into dog values ('Dubi', 2016, 2, 2)",
		"insert into dog values ('Lia', 2016, 2, 2)",
		"insert into member values ('Banana Joe', 'joe@banana-island.com', '648484')"
	};
}
