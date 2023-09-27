package SweetBank.sweetBank.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	private final String HOST = "localhost";
	private final String PORT = "3306";
	private final String VERITABANI_ISMI = "sweet_bank2";
	private final String USER = "root";
	private final String PASSWORD = "sa3010as";

	protected Connection connection = null;
	protected Statement statement = null;

	public DbConnection() {

		// jdbc:mysql://localhost:3306/sweet_bank
		String url = "jdbc:mysql://" + this.HOST + ":" + this.PORT + "/" + this.VERITABANI_ISMI;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.connection = DriverManager.getConnection(url, this.USER, this.PASSWORD);
			System.out.println("Bağlantı Başarılı :");
		} catch (SQLException e) {
			System.out.println("Bağlantı Başarısız :" + e.getMessage());
			e.printStackTrace();
		}

	}

}
