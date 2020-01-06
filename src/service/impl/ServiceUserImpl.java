/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.User;
import service.ServiceUser;
import storage.StorageUser;
import storage.impl.database.StorageDatabaseUser;

/**
 *
 * @author Nemanja
 */
public class ServiceUserImpl implements ServiceUser{

    private final StorageUser storageUser;

    public ServiceUserImpl() {
        storageUser =new StorageDatabaseUser();
    }
    
    @Override
    public User login(String username, String password) throws Exception {
        return storageUser.login(username, password);
    }
    
}
