/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.IDomainObject;
import domain.Nosnja;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface ServiceNosnja {

    public Nosnja sacuvajNo(Nosnja n);

    public Nosnja izmeniNo(Nosnja n);

    public void obrisiNo(Nosnja nosnja);

    public List<IDomainObject> vratiListuNo();

    public Nosnja vratiNo(Nosnja nosnja);

    public List<IDomainObject> vratiNosnjePoKrit(Nosnja nosnja);

    
    
}
