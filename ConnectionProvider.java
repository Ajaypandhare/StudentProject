package com.corejava.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionProvider {
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		
		// register driver class
		Class.forName("com.mysql.cj.jdbc.Driver") ;
		
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String password = "root";
		String username = "root";
		
		// establish connection between java application and database
		Connection con = DriverManager.getConnection(url, password, username) ;
		
		return con ; 
		
	}
	
	public static void insertRecord() throws ClassNotFoundException, SQLException {
	
		String query = "insert into student (name,marks) values(?,?)" ;

		Connection con = createConnection();
		
		Scanner sc = new Scanner(System.in) ;
		System.out.print("Enter Student Name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter Student Marks: ");
		float marks = sc.nextFloat();
		
		PreparedStatement stm = con.prepareStatement(query) ;
		stm.setString(1, name);
		stm.setFloat(2, marks);
		int num = stm.executeUpdate() ;
		
		System.out.println("student data successfully added..");
		System.out.println(num + " rows affected..");
	
	}
	
	public static void updateRecord() throws ClassNotFoundException, SQLException {
		
		String query = "update student set name=? where rollNum=?";
		
		// establish connection between java application and database
		Connection con = createConnection() ;
		
		Scanner sc = new Scanner(System.in) ;

		System.out.print("Enter Student Updated Name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter Student Roll Number To update : ");
		int rollnum = sc.nextInt();
		
		// create statement object
		PreparedStatement stm = con.prepareStatement(query) ;
		stm.setString(1, name);
		stm.setInt(2, rollnum);
		
		int num = stm.executeUpdate() ;
		
		System.out.println("Student data Updated successfully..");
		System.out.println(num + "row/s affected..");
		
		con.close();
		stm.close();
	
	}
	
	public static void deleteRecord() throws ClassNotFoundException, SQLException {
	
		String query = "delete from student where rollNum=?";
		
		// establish connection between java application and database
		Connection con = createConnection() ; ;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student Roll Number To delete: ");
		int rollnum = sc.nextInt();
		
		// create statement object
		PreparedStatement stm = con.prepareStatement(query) ;
		stm.setInt(1, rollnum);
		int num = stm.executeUpdate() ;
		
		System.out.println("Student data deleted successfully..");
		System.out.println(num + "row/s affected..");
		
		con.close();
		stm.close();
	}
	
	public static void fetchAllRecords() throws ClassNotFoundException, SQLException {

		String query = "select * from student";
		
		// establish connection between java application and database
		Connection con = createConnection() ;
		
		// create statement object
		Statement stm = con.createStatement() ;
		ResultSet res = stm.executeQuery(query) ;
		
		while (res.next()) {
			System.out.println("Stuudent roll number is: " + res.getInt("rollNum"));
			System.out.println("Student name is : " + res.getString("name"));
			System.out.println("Student marks are: " + res.getFloat("marks"));
			System.out.println("*********************************************************************************");
		}
		
		con.close();
		stm.close();
	}
	
}
