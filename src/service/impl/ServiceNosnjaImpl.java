/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import database.broker.DatabaseBroker;
import domain.IDomainObject;
import domain.Nosnja;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageNosnja;
import storage.impl.database.StorageDatabaseNosnja;

/**
 *
 * @author Nemanja
 */
public class ServiceNosnjaImpl implements service.ServiceNosnja{
    private final StorageNosnja storageNosnja;
    private final DatabaseBroker databaseBroker;

    public ServiceNosnjaImpl() {
        storageNosnja = new StorageDatabaseNosnja();
        databaseBroker = new DatabaseBroker();
    }

    @Override
    public Nosnja sacuvajNo(Nosnja n) {
        try {
            //return storageNosnja.sacuvajN(n);
            return (Nosnja) databaseBroker.save2(n);
        } catch (Exception ex) {
            Logger.getLogger(ServiceNosnjaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Nosnja izmeniNo(Nosnja n) {
        try {
            //return storageNosnja.izmeniN(n);
            return (Nosnja) databaseBroker.update(n);
        } catch (Exception ex) {
            Logger.getLogger(ServiceNosnjaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void obrisiNo(Nosnja nosnja) {
        try {
            //storageNosnja.obrisiN(sifra);
            databaseBroker.delete(nosnja);
        } catch (Exception ex) {
            Logger.getLogger(ServiceNosnjaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<IDomainObject> vratiListuNo() {
        try {
            //return storageNosnja.vratiListuN();
            return databaseBroker.getAll(new Nosnja());
        } catch (Exception ex) {
            Logger.getLogger(ServiceNosnjaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Nosnja vratiNo(Nosnja nosnja) {
        try {
            //return storageNosnja.vratiN(sifraNosnje);
            return (Nosnja) databaseBroker.getOne(nosnja);
        } catch (Exception ex) {
            Logger.getLogger(ServiceNosnjaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IDomainObject> vratiNosnjePoKrit(Nosnja nosnja) {
        try {
            //return storageNosnja.vratiNosnjuPoK(kriterijumPretrage, naziv, vrsta);
            return databaseBroker.getByCrit(nosnja);
        } catch (Exception ex) {
            Logger.getLogger(ServiceNosnjaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
