/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clan;

import domain.IDomainObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class ObrisiClana extends AbstractGenericOperation {

    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {

    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        databaseBroker.delete(domainObject);
    }

}
