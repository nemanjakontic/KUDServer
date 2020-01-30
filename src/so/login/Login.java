/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import domain.IDomainObject;
import domain.User;
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class Login extends AbstractGenericOperation{

    User user;
    
    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {
        
    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        user = (User) databaseBroker.getOne((User)domainObject);
    }

    public User getUser() {
        return user;
    }
    
    
    
}
