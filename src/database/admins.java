package database;

import java.sql.Statement;

import resources.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class admins {
	public static void main(String[] args) throws Exception {
		Connection con =DBconnection.connection();
		
		Statement str= con.createStatement();
		
		 String sql = 	"CREATE TABLE ADMINS" +
                 		"(id int not NULL AUTO_INCREMENT, " +
                 		" name VARCHAR(255), " + 
                 		" email VARCHAR(255), " + 
                 		" password TEXT, " + 
                 		" update_at TIMESTAMP default CURRENT_TIMESTAMP ," +
                 		" PRIMARY KEY ( id ))";
		 str.executeUpdate(sql);
		 
		 adminInsart();
// CREATE TABLE ADMINS (id int not NULL AUTO_INCREMENT,  name VARCHAR(255),  email VARCHAR(255),  password INTEGER,  PRIMARY KEY ( id ))


	}
	
	
	public static void adminInsart() throws Exception {
		
		PreparedStatement admins = DBconnection.connection().prepareStatement("insert into admins (name, email, password) values(?,?,?)");
							admins.setString(1, "Admin");
							admins.setString(2, "admin@gmail.com");
							admins.setString(3, "123456");
							admins.executeUpdate();
		
	}
	
}
