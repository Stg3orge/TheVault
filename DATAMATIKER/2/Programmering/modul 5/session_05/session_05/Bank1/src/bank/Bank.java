package bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Bank {
	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		try (Connection con = DriverManager
				.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=minibank;user=sa;password=masterkey")) {
			System.out.println("connected");
			try (PreparedStatement ps = con.prepareStatement("insert into posting (account_id, posting) values (?, ?)",
					Statement.RETURN_GENERATED_KEYS)) {
				
				con.setAutoCommit(false);

				// from account 1 transfer 123.0 moneys
				ps.setInt(1, 1);
				ps.setDouble(2, -123d);
				ps.executeUpdate();
				
				// ... to account 2, the same amount moneys (123.0)
				ps.setInt(1, 2);
				ps.setDouble(2, 123d);
				ps.execute();
				if(true && LocalDate.now().isBefore(LocalDate.of(2222, 2, 2))) {// make exception optional
					throw new SQLException();
				}
				
				con.commit();
				
				System.out.println("transferred");
			} catch (SQLException e) {
				
				con.rollback();
				
				System.out.println("rolled back");
			} finally {
				
				con.setAutoCommit(true);

				System.out.println("autocommit restored");
			}
			
			// display status after commit
			ResultSet rs = con.createStatement().executeQuery("select account_id, sum(posting) from posting group by account_id");
			displayResultSet(rs);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	private static void displayResultSet(ResultSet rs) throws SQLException {
		while (rs.next()) {
			int colCount = rs.getMetaData().getColumnCount();
			String output = "";
			for (int i = 1; i <= colCount; i++) {
				output += rs.getString(i) + "\t";
			}
			System.out.println(output);
		}
		System.out.println("-----------------------------------------------------------------");

	}
}
