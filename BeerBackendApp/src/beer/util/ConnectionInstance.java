package beer.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class ConnectionInstance {

	private static Connection con = null;

	public static Connection createInstance() {

		Properties prop = new Properties();

		if (con == null) {
			try {
				FileReader fr = new FileReader("K://propfiles/dbcred.properties");
				prop.load(fr);
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", prop);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return con;
	}

	

}
