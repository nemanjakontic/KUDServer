/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.izdavanjeNosnje;

import domain.IDomainObject;
import domain.IzmeneOtpremnice;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class VratiOtpremnicu extends AbstractGenericOperation{

    private Otpremnica otpremnica;
    
    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {
        
    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        otpremnica = (Otpremnica) databaseBroker.getOne(domainObject);
    }

    public Otpremnica getOtpremnica() {
        return otpremnica;
    }
    
}
