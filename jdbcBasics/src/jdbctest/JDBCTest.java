package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
//		readFromDb();
//		insertIntoDb();
		updateDb();
//		deleteDb();

	}
		
	private static void readFromDb() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Samsudeen21");
				Statement statement = connection.createStatement();){
			
			ResultSet resultSet = statement.executeQuery("select * from account");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3)
						+ ", " + resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	private static void insertIntoDb() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Samsudeen21");
				Statement statement = connection.createStatement();){
			
			int rowsInserted = statement.executeUpdate("insert into account values(4, 'mary', 'lucas', 150000)");
			System.out.println("Number of rows inserted : " + rowsInserted);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void updateDb() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Samsudeen21");
				Statement statement = connection.createStatement();){
			
			int rowsInserted = statement.executeUpdate("update account set accno=1 where balance=2000");
			System.out.println("Number of rows inserted : " + rowsInserted);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteDb() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Samsudeen21");
				Statement statement = connection.createStatement();){
			
			int rowsInserted = statement.executeUpdate("delete from account where balance=1000");
			System.out.println("Number of rows inserted : " + rowsInserted);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	}

