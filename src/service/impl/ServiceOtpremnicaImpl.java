/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import database.broker.DatabaseBroker;
import domain.IDomainObject;
import domain.IzmeneOtpremnice;
import domain.Otpremnica;
import domain.StavkaOtpremnice;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ServiceOtpremnica;
import storage.StorageOtpremnica;
import storage.impl.database.StorageDatabaseOtpremnica;

/**
 *
 * @author Nemanja
 */
public class ServiceOtpremnicaImpl implements ServiceOtpremnica{
    private final StorageOtpremnica storageOtpremnica;
    private final DatabaseBroker databaseBroker;

    public ServiceOtpremnicaImpl() {
        storageOtpremnica = new StorageDatabaseOtpremnica();
        databaseBroker = new DatabaseBroker();
    }
    
    
    
    @Override
    public Otpremnica sacuvajOt(Otpremnica o) {
        o.setDatumKreiranja(new Date());
        try {
            return (Otpremnica) databaseBroker.save2(o);
        } catch (Exception ex) {
            Logger.getLogger(ServiceOtpremnicaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Otpremnica izmeniOtpremnicu(Otpremnica o) {
        o.setDatumKreiranja(new Date());
        try {
            return storageOtpremnica.izmeniO(o);
        } catch (Exception ex) {
            Logger.getLogger(ServiceOtpremnicaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<IDomainObject> vratiOt() {
        try {
            //return storageOtpremnica.vratiSveO();
            return databaseBroker.getAll(new Otpremnica());
        } catch (Exception ex) {
            Logger.getLogger(ServiceOtpremnicaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Otpremnica vratiOt(Otpremnica otpremnica) {
        try {
            //return storageOtpremnica.vratiOtp(sifraOtpremnice);
            return (Otpremnica) databaseBroker.getOne(otpremnica);
        } catch (Exception ex) {
            Logger.getLogger(ServiceOtpremnicaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<IDomainObject> vratiOtpPoKrt(Otpremnica otpremnica) {
        try {
            //return storageOtpremnica.vratiOtpPoKr(sifra, clan);
            return databaseBroker.getByCrit(otpremnica);
        } catch (Exception ex) {
            Logger.getLogger(ServiceOtpremnicaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void obrisiOtp(Otpremnica otpremnica) {
        try {
            //storageOtpremnica.obrisiO(sifra);
            databaseBroker.delete(otpremnica);
        } catch (Exception ex) {
            Logger.getLogger(ServiceOtpremnicaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
