package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Hospital {
	//private static final Statement DBUtil = null;
	private static Connection con;
	private static PreparedStatement pst;
	private static Scanner sc=new Scanner(System.in);
	private static ResultSet rs;
	public static void create() throws ClassNotFoundException, SQLException {
		//con=Util.getConnection();
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","12password12");
		pst=con.prepareStatement("create table Patients(Patients-ID Number(5),Patients-firstname varchar2(20),Patients-lastname varchar2(20),Patients-Age Number(10))");
		pst=con.prepareStatement("create table Appointments(Appointment-date number(5) ,Date-of-Booking number(5))");
		pst=con.prepareStatement("create table Staff(Staff-FirstName varchar2(5),Staff-LastName varchar2(5) ,Staff-Id Number(5),Staff-Age Number(5)");
		pst=con.prepareStatement("create table Department(Department-ID Number(5),Department-Name varchar2(10))");
		pst.execute();
		System.out.println("Table created");
	}
	public static void insert() throws ClassNotFoundException, SQLException {
		//con=Util.getConnection();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","12password12");
		pst=con.prepareStatement("insert into Patients values(001,'jack','sparrow',35)");
		pst=con.prepareStatement("insert into Appointments values(20-8-24,10-08-24)");
		pst=con.prepareStatement("insert into Staff values('vinoth','Kumar','161',20)");
		pst=con.prepareStatement("insert into Departments values(201,'OutPatient')");
	   	System.out.println("Inserted");
	}
	public static void update() throws ClassNotFoundException, SQLException {
		//con=Util.getConnection();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","12password12");
		pst=con.prepareStatement("update Patients set Age=36 where Patients-ID=001");
		pst=con.prepareStatement("update Appointments set Appointment-date=21-08-24 ");
		pst=con.prepareStatement("update Staff set Staff-LastName=vino where Staff-Id=161");
		pst=con.prepareStatement("update Departments set Department-Name='Inpatient' Department-ID=200");
		pst.executeUpdate();
		System.out.println("Updated");
	}
	public static void delete() throws ClassNotFoundException, SQLException {
		//con=Util.getConnection();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","12password12");
		pst=con.prepareStatement("delete from Patients where patients-ID=101");
		pst=con.prepareStatement("delete from Appointments ");
		pst=con.prepareStatement("delete from Staff where Staff-Id=161");
		pst=con.prepareStatement("delete from Departments where Departments-ID=200");
		pst.executeUpdate();
		System.out.println("deleted");
	}
	public static void read() throws ClassNotFoundException, SQLException {
		//con=Util.getConnection();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","12password12");
		pst=con.prepareStatement("select * from patients");
		rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "
		+rs.getString(3)+" "+rs.getInt(4));
		}
		
		pst=con.prepareStatement("select * from Appointments");
		rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getInt(2));
		}
		
		pst=con.prepareStatement("select * from Staff");
		rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "
		+rs.getInt(3));
		}
		
		pst=con.prepareStatement("select * from Departments");
		rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getInt(2));
		}
		
		 
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		create();
		//insert();
		//update();
		//delete();
		//read();
	}

}
