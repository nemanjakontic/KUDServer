/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.IDomainObject;
import domain.Otpremnica;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public interface ServiceOtpremnica {

    public Otpremnica sacuvajOt(Otpremnica o);

    public Otpremnica izmeniOtpremnicu(Otpremnica o);

    public List<IDomainObject> vratiOt();

    public Otpremnica vratiOt(Otpremnica otpremnica);

    public List<IDomainObject> vratiOtpPoKrt(Otpremnica otpremnica);

    public void obrisiOtp(Otpremnica otpremnica);
    
}
