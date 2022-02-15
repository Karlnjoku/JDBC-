/*JDBC API*/

import java.sql.DriverManager; 

import java.sql.Connection; 

import java.sql.Statement; 

import java.sql.ResultSet; 

import java.util.Scanner; 

 





public class DBCONNECT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); 

		 

		String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";//mysql driver name 

		 

		String URL = "jdbc:mysql://localhost:3306/users";//mysql schema name 

		String user = "root";// mysql workbench user name 

		String pass = "peternjoku360";//mysql workbench password 

		  

		try { 

		

		Class.forName ("com.mysql.cj.jdbc.Driver");// coming from ext lib 

		 

		

		Connection con = DriverManager.getConnection(URL, user, pass); 

		 



		Statement stmt = con.createStatement(); 

		 

		

		if(con != null) 

		{ 

		System.out.println("Connection done !"); 

		} 

		 

	

		 

	

		String qry1 = "select * from pieers"; 

		ResultSet rs = stmt.executeQuery(qry1); 

		while(rs.next()) 

		{ 

		System.out.println("Pieer eid : "+rs.getInt("eid")); 

		System.out.println("Pieer ename : "+rs.getString("ename")); 

		System.out.println("Pieer subject : "+rs.getString("subject")); 

		System.out.println("Pieer score : "+rs.getDouble("score")); 

		} 

		System.out.println("========================="); 

		 

		

		 

		System.out.println("Enter Pieer eid : "); 

		int sid = sc.nextInt(); 

		 

		System.out.println("Enter Pieer ename : "); 

		String name = sc.next(); 

		 

		System.out.println("Enter Pieer subject : "); 

		String subject = sc.next(); 

		 

		System.out.println("Enter Pieer score : "); 

		double score = sc.nextDouble(); 

		 

		String qry2 = "insert into student(eid,ename,subject,score) values("+sid+",'"+name+"','"+subject+"',"+score+")"; 

		int insert_count = stmt.executeUpdate(qry2); 

		if(insert_count != 1) 

		{ 

		System.out.println("Please check query..."); 

		} 

		 

		 

		 

		} 

		catch(Exception ex) 

		{ 

		System.out.println("DB Connection error"+ex); 

		} 

		 

		} 

		 

		} 

