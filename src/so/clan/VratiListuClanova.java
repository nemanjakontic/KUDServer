/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clan;

import domain.Clan;
import domain.IDomainObject;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class VratiListuClanova extends AbstractGenericOperation{

    List<IDomainObject> clanovi;
    
    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {
        
    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        clanovi = databaseBroker.getAll((Clan)domainObject);
    }

    public List<IDomainObject> getClanovi() {
        return clanovi;
    }
    
    
    
}
