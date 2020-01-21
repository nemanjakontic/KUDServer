/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import database.broker.DatabaseBroker;
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
    private final DatabaseBroker databaseBroker;

    public ServiceUserImpl() {
        storageUser =new StorageDatabaseUser();
        databaseBroker = new DatabaseBroker();
    }
    
    @Override
    public User login(User user) throws Exception {
        //return storageUser.login(username, password);
        return (User) databaseBroker.getOne(user);
    }
    
}
