/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import database.broker.DatabaseBroker;
import domain.Clan;
import domain.IDomainObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ServiceClan;
import storage.StorageClan;
import storage.impl.database.StorageDatabaseClan;

/**
 *
 * @author Nemanja
 */
public class ServiceClanImpl implements ServiceClan{
    private final StorageClan storageClan;
    //novo
    private final DatabaseBroker databaseBroker;

    public ServiceClanImpl() {
        storageClan = new StorageDatabaseClan();
        databaseBroker = new DatabaseBroker();
    }

    @Override
    public Clan zapamtiCl(Clan clan) {
        try {
            //return storageClan.zapamtiC(clan);
            return (Clan) databaseBroker.save2(clan);
        } catch (Exception ex) {
            Logger.getLogger(ServiceClanImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void obrisiCl(Clan clan) {
        try {
            //storageClan.obrisiC(clan);
            databaseBroker.delete(clan);
        } catch (Exception ex) {
            Logger.getLogger(ServiceClanImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Clan izmeniCl(Clan clan) {
        try {
            //return storageClan.izmeniC(clan);
            return (Clan) databaseBroker.update(clan);
        } catch (Exception ex) {
            Logger.getLogger(ServiceClanImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<IDomainObject> vratiListuCl() {
        try {
            //return storageClan.vratiListuC();
            return databaseBroker.getAll(new Clan());
        } catch (Exception ex) {
            Logger.getLogger(ServiceClanImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Clan vratiCl(Clan clan) {
        try {
            //return storageClan.vratiC(brojCK);
            return (Clan) databaseBroker.getOne(clan);
        } catch (Exception ex) {
            Logger.getLogger(ServiceClanImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<IDomainObject> vratiClanovePoKriterijumu(Clan clan) {
        try {
            //return storageClan.vratiClanovePoKr(sifra, ime, prezime);
            return databaseBroker.getByCrit(clan);
        } catch (Exception ex) {
            Logger.getLogger(ServiceClanImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
