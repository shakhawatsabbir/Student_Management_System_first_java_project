package database;

import java.sql.Connection;
import java.sql.Statement;

import resources.DBconnection;

public class courses {
	public static void main(String[] args) throws Exception {
		Connection con = DBconnection.connection();
		
		Statement stmt = con.createStatement();
		
		String sql = 	"CREATE TABLE COURSES ("+
						"id INT not NULL AUTO_INCREMENT ,"+
						"title VARCHAR(255) ,"+
						"code VARCHAR(255) ,"+
						"price INT ,"+
						"credit_houre INT ,"+
						"update_at TIMESTAMP default CURRENT_TIMESTAMP,"+
						"PRIMARY KEY (id))";
		 
		stmt.executeUpdate(sql);
	}
}
