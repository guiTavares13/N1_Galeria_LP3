package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public abstract class ConexaoDao {
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
            	
            	
            	//Properties prop = new Properties();
            	
            	
                //nputStream inputStream = ConexaoDao.class.getClassLoader().getResourceAsStream("/db.resources");

                String driver, url, user, password;              

				//prop.load(inputStream);
     
				driver = "driver=com.mysql.jdbc.Driver";
	            url = "jdbc:mysql://localhost:3306//db_galeria";
	            user = "root";
	            password = "123456";
	                
	            //Log
				System.out.println(driver + " - " + url );
			                        
                Class.forName(driver);
                
                connection = DriverManager.getConnection(url, user, password);
            
                System.out.println(connection);
                
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            
            return connection;
        } //if

    } //getConnection
}
