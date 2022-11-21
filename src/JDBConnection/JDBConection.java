/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aspire E5-576
 */
public class JDBConection {
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3305/qltaikhoan";
		String username="root";
		String password="hieu123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				return DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
     
}
