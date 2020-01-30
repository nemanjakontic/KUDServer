/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import database.broker.DatabaseBroker;
import database.connection.ConnectionFactory;
import domain.IDomainObject;
import java.sql.SQLException;

/**
 *
 * @author Nemanja
 */
public abstract class AbstractGenericOperation {
    protected DatabaseBroker databaseBroker;

    public AbstractGenericOperation() {
        databaseBroker = new DatabaseBroker();
    }

    public final void execute(IDomainObject domainObject) throws Exception{
        try {
            preconditions(domainObject);
            startTransaction();
            executeOperation(domainObject);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        }
    }

    protected abstract void preconditions(IDomainObject domainObject) throws Exception;

    private void startTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().setAutoCommit(false);
    }

    protected abstract void executeOperation(IDomainObject domainObject)  throws Exception;

    private void commitTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().commit();
    }

    private void rollbackTransaction() throws SQLException {
        ConnectionFactory.getInstance().getConnection().rollback();
    }
    
    
}
