/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Clan;
import domain.IDomainObject;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface ServiceClan {

    public Clan zapamtiCl(Clan clan);

    public void obrisiCl(Clan clan);

    public Clan izmeniCl(Clan clan);

    public List<IDomainObject> vratiListuCl();

    public Clan vratiCl(Clan clan);

    public List<IDomainObject> vratiClanovePoKriterijumu(Clan clan);

    
    
}
