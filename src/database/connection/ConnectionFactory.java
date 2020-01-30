/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nemanja
 */
public class ConnectionFactory {

    private Connection connection;
    public static ConnectionFactory instance;

    private ConnectionFactory() throws SQLException {
        try {
            String url = Podesavanja.getInstance().getProperty("url");
            String username = Podesavanja.getInstance().getProperty("user");
            String password = Podesavanja.getInstance().getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new SQLException("Connection is not created!");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

}
