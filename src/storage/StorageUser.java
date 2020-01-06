/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.User;

/**
 *
 * @author Nemanja
 */
public interface StorageUser {

    public User login(String username, String password) throws Exception;
    
}
