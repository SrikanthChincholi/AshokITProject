package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class DBConfig {

	public static List<EmployeeClass> dbconfig() throws ClassNotFoundException, SQLException

	{
		List<EmployeeClass> emp = new ArrayList<EmployeeClass>();
		final String url = "jdbc:mysql:///Employee";
		final String user = "root";
		final String pswd = "Srikanth@kk42";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pswd);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select username, epassword from employee");
		while (rs.next()) {
			EmployeeClass eclass = new EmployeeClass();
			eclass.setUsername(rs.getString("username"));
			eclass.setEpassword(rs.getString("epassword"));
			emp.add(eclass);
		}
		return emp;
	}

	
	public static void readDB() throws Exception, SQLException {
		List<EmployeeClass> employeedetails = DBConfig.dbconfig();
		for (EmployeeClass details : employeedetails) {
			System.out.println(details.getUsername() + " " + details.getEpassword());
		}

	}
}
