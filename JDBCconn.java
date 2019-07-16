
import java.sql.*;
import javax.swing.*;

public class JDBCconn {
	
	Connection conn = null;

	public static Connection dbconn() {
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practise","root","root");
			
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
	}

}
