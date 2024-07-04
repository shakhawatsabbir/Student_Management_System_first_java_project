package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import resources.DBconnection;

public class Enroll {
	public static void main(String[] args) throws Exception {
		Connection con = DBconnection.connection();
		
		Statement stmt = con.createStatement();
		
		String sql = 	"CREATE TABLE ENROLLS ("+
						"id INT not NULL AUTO_INCREMENT ,"+
						"student_id INT ,"+
						"courses_id INT ,"+
						"update_at TIMESTAMP default CURRENT_TIMESTAMP,"+
						"PRIMARY KEY (id))";
		
		stmt.executeUpdate(sql);
	}
	
	public static PreparedStatement enrollInsart() throws Exception {
		
		PreparedStatement enroll = DBconnection.connection().prepareStatement("insert into enrolls (student_id, courses_id) values(?,?)");
		return enroll;
	}
}
