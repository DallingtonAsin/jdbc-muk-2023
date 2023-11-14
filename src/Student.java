import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Student {
	
	private Connection returnConnectionObj() throws Exception {
		try {
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // registered the mysql driver
			
			String url = "jdbc:mysql://localhost:3306/makerere";
			Properties prop = new Properties();
			prop.setProperty("user", "Dallington");
			prop.setProperty("password", "Dallington100");
			
			Connection con = DriverManager.getConnection(url, prop);
			System.out.println("Database connection established successfully");
			return con;
			
		}catch(Exception $ex) {
			throw $ex;
		}
	}
	
	protected void register(Connection con, String name, int age) throws Exception {
		try {
			
			String inQuery = "INSERT INTO students(name, age) VALUES(?,?)";
			PreparedStatement ps = con.prepareStatement(inQuery);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.execute();
			System.out.println("Student "+name+" has been registered successfully");
			
		}catch(Exception e) {
			throw e;
		}
	}
	
	protected PreparedStatement getPreparedStmtObj(Connection con, String sqlQuery) throws Exception {
		try{	
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			return ps;
		}catch(Exception e) {
			throw e;
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			Student student = new Student();
	
			
			Connection con = student.returnConnectionObj();
			Statement stmt = con.createStatement();
//		    String dbQuery =  "CREATE DATABASE makerere";
//		    stmt.execute(dbQuery);
//		    System.out.println("Database makerere has been created successfully");
			
//			String tblQuery = "CREATE TABLE students(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50), age INT(80))";
//			stmt.execute(tblQuery);
//			System.out.println("Table student has been created successfully");
			
//			String insQuery = "INSERT INTO students(name, age) VALUES('Peter', 21)";
//			stmt.execute(insQuery);
//			System.out.println("Student record has been inserted successfully");
			
//			String fetchQuery = "SELECT * from students WHERE age>17";
//			ResultSet rs = stmt.executeQuery(fetchQuery);
//			while(rs.next()) {
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				System.out.println(name + " is " + age + " years old");
//			}
			
//			String delQuery = "DELETE FROM students WHERE id=2";
//			stmt.execute(delQuery);
//			System.out.println("The student whose id is 2 has been deleted successfully");
			
//			String updQuery = "UPDATE students SET age=17 WHERE id=1";
//			stmt.executeUpdate(updQuery);
//			System.out.println("The student whose id is 1 has his/her age updated to 17");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter student's name");
			String std_name = sc.nextLine();
			System.out.println("Enter student's age");
			int std_age = sc.nextInt();
			student.register(con, std_name, std_age);
			
		
//			System.out.println("Enter student's id whose age is to be updated");
//			int _id = sc.nextInt();
//			System.out.println("Enter the new age of the student");
//			int _age = sc.nextInt();
//			String upQuery = "UPDATE students SET age=? WHERE id=?";
//			PreparedStatement pst = con.prepareStatement(upQuery);
//			pst.setInt(1, _age);
//			pst.setInt(2, _id);
//			pst.execute();
//			System.out.println("Student whose id is "+_id+" has his/her age updated to "+_age+"");
//			
			
//			String query = "CALL fetchStudents()";
//			CallableStatement cs = con.prepareCall(query);
//			ResultSet rs = cs.executeQuery();
//			while(rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				System.out.println(id + ": "+name+" is " +age + " years old");
//			}

		}catch(Exception ex) {
			System.out.println("Caught exception "+ex.getMessage());
		}
		
	}

}
