/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.nosnja;

import domain.IDomainObject;
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class ObrisiNosnju extends AbstractGenericOperation{

    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {
        
    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        databaseBroker.delete(domainObject);
    }
    
}
