/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionFactory;
import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import storage.StorageUser;

/**
 *
 * @author Nemanja
 */
public class StorageDatabaseUser implements StorageUser {

    @Override
    public User login(String username, String password) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String query = "Select * from users where username=?";// and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setFirstname(rs.getString("ime"));
            user.setLastname(rs.getString("prezime"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setId(rs.getLong("id"));
            rs.close();
            preparedStatement.close();
            return user;
        }

        rs.close();
        preparedStatement.close();
        throw new Exception("No such user");

    }

}
