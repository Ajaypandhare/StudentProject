package com.corejava.jdbc.demo;

import java.sql.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		while(true) {
			System.out.println("************** Welcome To Student Management System Project **************");
			System.out.println("                   1 : List Of Students");
			System.out.println("                   2 : Add new Students");
			System.out.println("                   3 : Update Student");
			System.out.println("                   4 : Delete Student");
			System.out.println("                   5 : Exit");
			
			System.out.println();
			System.out.print("Enter Your Choice: ");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt() ;
			System.out.println();
			
			if(ch == 1) {
				ConnectionProvider.fetchAllRecords();
			}else if(ch == 2) {
				ConnectionProvider.insertRecord();
			}else if(ch == 3) {
				ConnectionProvider.updateRecord();
			}else if(ch == 4) {
				ConnectionProvider.deleteRecord();
			}else if(ch == 5) {
				System.out.println("Thanks for visit");
				break ;
			}
			
			System.out.println();
		}
		
		

	}

}
