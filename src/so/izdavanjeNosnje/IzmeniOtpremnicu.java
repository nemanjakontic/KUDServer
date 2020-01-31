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
import so.AbstractGenericOperation;

/**
 *
 * @author Nemanja
 */
public class IzmeniOtpremnicu extends AbstractGenericOperation{

    private Otpremnica otpremnica;
    
    @Override
    protected void preconditions(IDomainObject domainObject) throws Exception {
        
    }

    @Override
    protected void executeOperation(IDomainObject domainObject) throws Exception {
        otpremnica = (Otpremnica) databaseBroker.update(domainObject);
        IDomainObject vezo1 = domainObject.vratiVezaniObjekat(0);
        IDomainObject vezo2 = domainObject.vratiVezaniObjekat(1);
        vezo1.setId(((Otpremnica)domainObject).getSifraOtpremnice());
        vezo2.setId(((Otpremnica)domainObject).getSifraOtpremnice());
        databaseBroker.delete(vezo1);
        databaseBroker.delete(vezo2);
        
        for (StavkaOtpremnice stavkaOtpremnice : ((Otpremnica)domainObject).getStavkaOtpremnice()) {
            stavkaOtpremnice.setId(((Otpremnica)domainObject).getSifraOtpremnice());
            databaseBroker.save2((StavkaOtpremnice)stavkaOtpremnice);
        }
        for (IzmeneOtpremnice izmenaOtpremnice : ((Otpremnica)domainObject).getIzmenaOtpremnice()) {
            izmenaOtpremnice.setId(((Otpremnica)domainObject).getSifraOtpremnice());
            databaseBroker.save2((IzmeneOtpremnice)izmenaOtpremnice);
        }
        
    }

    public Otpremnica getOtpremnica() {
        return otpremnica;
    }
    
}
