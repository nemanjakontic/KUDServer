/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.nosnja;

import domain.IDomainObject;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class VratiNosnjePoKriterijumu extends AbstractGenericOperation{

    List<IDomainObject> nosnje;
    
    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {
        
    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        nosnje = databaseBroker.getByCrit(domainObject);
    }

    public List<IDomainObject> getNosnje() {
        return nosnje;
    }
    
}
