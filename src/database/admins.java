package database;

import java.sql.Statement;
import java.sql.Connection;
import Project360.DBconnection;

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
		 
		 
// CREATE TABLE ADMINS (id int not NULL AUTO_INCREMENT,  name VARCHAR(255),  email VARCHAR(255),  password INTEGER,  PRIMARY KEY ( id ))


	}
}
