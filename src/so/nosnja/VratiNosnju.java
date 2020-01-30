/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.nosnja;

import domain.IDomainObject;
import domain.Nosnja;
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class VratiNosnju extends AbstractGenericOperation{

    private Nosnja nosnja;
    
    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {
        
    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        nosnja = (Nosnja) databaseBroker.getOne(domainObject);
    }

    public Nosnja getNosnja() {
        return nosnja;
    }
    
    
    
}
