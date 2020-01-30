/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.izdavanjeNosnje;

import domain.IDomainObject;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class VratiOtpremnicePoKrit extends AbstractGenericOperation{

    List<IDomainObject> otpremnice;
    
    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {
        
    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        otpremnice = databaseBroker.getByCrit(domainObject);
    }

    public List<IDomainObject> getOtpremnice() {
        return otpremnice;
    }
    
}
