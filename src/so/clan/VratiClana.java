/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clan;

import domain.Clan;
import domain.IDomainObject;
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class VratiClana extends AbstractGenericOperation{

    private Clan clan;
    
    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {
        
    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        clan = (Clan) databaseBroker.getOne((Clan)domainObject);
    }

    public Clan getClan() {
        return clan;
    }
    
    
    
}
