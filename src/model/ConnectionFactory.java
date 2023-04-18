package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() throws IOException {
		Properties prop= getProperties();
		final String url = prop.getProperty("dataBase.url");
		final String user = prop.getProperty("dataBase.user");
		final String password = prop.getProperty("dataBase.password");
		
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(url);
		comboPooledDataSource.setUser(user);
		comboPooledDataSource.setPassword(password);
		
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection getConecction() throws SQLException {
		return this.dataSource.getConnection();
	}
	
	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String path = "/connection.properties";
		prop.load(ConnectionFactory.class.getResourceAsStream(path));
		return prop;
	}
}
