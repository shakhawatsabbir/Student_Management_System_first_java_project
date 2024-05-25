package database;

import java.sql.Statement;

import resources.DBconnection;

import java.sql.Connection;

public class student {
	public static void main(String[] args) throws Exception {
		Connection con =DBconnection.connection();
		
		Statement str= con.createStatement();
		
		 String sql = 	"CREATE TABLE STUDENTS" +
                 		"(id int not NULL AUTO_INCREMENT, " +
                 		" name VARCHAR(255), " + 
                 		" email VARCHAR(255), " + 
                 		" password TEXT, " + 
                 		" update_at TIMESTAMP default CURRENT_TIMESTAMP ," +
                 		" PRIMARY KEY ( id ))";
		 str.executeUpdate(sql);
		 
		 
// CREATE TABLE STUDENTS (id int not NULL AUTO_INCREMENT,  name VARCHAR(255),  email VARCHAR(255),  password INTEGER,  PRIMARY KEY ( id ))


	}
}
