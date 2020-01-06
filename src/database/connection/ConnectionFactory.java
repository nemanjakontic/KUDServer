/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connection;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Nemanja
 */
public class ConnectionFactory {
    private Connection connection;
    public static ConnectionFactory instance;
    
    private ConnectionFactory() throws SQLException{
        /*String url = "jdbc:mysql://localhost:3306/kulturnoumetnickodrustvo";
        String username = "root";
        String password = "";*/
        
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("config/dbconfig.properties");
            properties.load(fis);
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            //connection.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new SQLException("Connection is not created!");
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
 
    public static ConnectionFactory getInstance() throws SQLException{
        if(instance == null){
            instance = new ConnectionFactory();
        }
        return instance;
    }
    
    
   
}
