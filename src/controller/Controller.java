/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Clan;
import domain.IDomainObject;
import domain.Nosnja;
import domain.Otpremnica;
import domain.User;
import java.util.List;
import so.AbstractGenericOperation;
import so.clan.IzmeniClana;
import so.clan.ObrisiClana;
import so.clan.SaveClan;
import so.clan.VratiClana;
import so.clan.VratiClanovePoKriterijumu;
import so.clan.VratiListuClanova;
import so.izdavanjeNosnje.IzmeniOtpremnicu;
import so.izdavanjeNosnje.ObrisiOtpremnicu;
import so.izdavanjeNosnje.SaveOtpremnica;
import so.izdavanjeNosnje.VratiListuOtpremnica;
import so.izdavanjeNosnje.VratiOtpremnicePoKrit;
import so.izdavanjeNosnje.VratiOtpremnicu;
import so.login.Login;
import so.nosnja.IzmeniNosnju;
import so.nosnja.ObrisiNosnju;
import so.nosnja.SaveNosnja;
import so.nosnja.VratiListuNosnji;
import so.nosnja.VratiNosnjePoKriterijumu;
import so.nosnja.VratiNosnju;

/**
 *
 * @author Nemanja
 */
public class Controller {
    private static Controller instance;

    private Controller() {

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Clan saveClan(Clan clan) throws Exception {
        AbstractGenericOperation saveClan = new SaveClan();
        saveClan.execute(clan);
        return ((SaveClan)saveClan).getClan();
    }

    public User login(User user1) throws Exception {
        AbstractGenericOperation login = new Login();
        login.execute(user1);
        return ((Login)login).getUser();
    }

    public Clan vratiClana(Clan data) throws Exception {
        AbstractGenericOperation vratiClana = new VratiClana();
        vratiClana.execute(data);
        return ((VratiClana)vratiClana).getClan();
    }

    public List<IDomainObject> vratListuCl(Clan clan) throws Exception {
        AbstractGenericOperation vratiListuCl = new VratiListuClanova();
        vratiListuCl.execute(clan);
        return ((VratiListuClanova)vratiListuCl).getClanovi();
    }

    public List<IDomainObject> vratiClanovePoKriterijumu(Clan clan) throws Exception {
        AbstractGenericOperation vratiClanovePoKriterijumu = new VratiClanovePoKriterijumu();
        vratiClanovePoKriterijumu.execute(clan);
        return ((VratiClanovePoKriterijumu)vratiClanovePoKriterijumu).getClanovi();
    }

    public void obrisiClana(Clan clan) throws Exception {
        AbstractGenericOperation obrisiClana = new ObrisiClana();
        obrisiClana.execute(clan);
    }

    public Clan izmeniClana(Clan clan) throws Exception {
        AbstractGenericOperation izmeniClana = new IzmeniClana();
        izmeniClana.execute(clan);
        return ((IzmeniClana)izmeniClana).getClan();
    }

    public Nosnja saveNosnja(Nosnja nosnja) throws Exception {
        AbstractGenericOperation saveNosnja = new SaveNosnja();
        saveNosnja.execute(nosnja);
        return ((SaveNosnja)saveNosnja).getNosnja();
    }

    public void obrisiNosnju(Nosnja nosnja) throws Exception {
        AbstractGenericOperation obrisiNosnju = new ObrisiNosnju();
        obrisiNosnju.execute(nosnja);
    }

    public Nosnja izmeniNosnju(Nosnja nosnja) throws Exception {
        AbstractGenericOperation izmeniNosnju = new IzmeniNosnju();
        izmeniNosnju.execute(nosnja);
        return ((IzmeniNosnju)izmeniNosnju).getNosnja();
    }

    public Nosnja vratiNosnju(Nosnja nosnja) throws Exception {
        AbstractGenericOperation vratiNosnju = new VratiNosnju();
        vratiNosnju.execute(nosnja);
        return ((VratiNosnju)vratiNosnju).getNosnja();
    }

    public List<IDomainObject> vratiListuNosnji(Nosnja nosnja) throws Exception {
        AbstractGenericOperation vratiListuNosnji = new VratiListuNosnji();
        vratiListuNosnji.execute(nosnja);
        return ((VratiListuNosnji)vratiListuNosnji).getNosnje();
    }

    public List<IDomainObject> vratiNosnjePoKrit(Nosnja nosnja) throws Exception {
        AbstractGenericOperation vratiNosnjePoKrit = new VratiNosnjePoKriterijumu();
        vratiNosnjePoKrit.execute(nosnja);
        return ((VratiNosnjePoKriterijumu)vratiNosnjePoKrit).getNosnje();
    }

    public Otpremnica saveOtpremnica(Otpremnica otpremnica) throws Exception {
        AbstractGenericOperation saveOtpremnica = new SaveOtpremnica();
        saveOtpremnica.execute(otpremnica);
        return ((SaveOtpremnica)saveOtpremnica).getOtpremnica();
    }

    public Otpremnica izmeniOtpremnicu(Otpremnica otpremnica) throws Exception {
        AbstractGenericOperation izmeniOtpremnicu = new IzmeniOtpremnicu();
        izmeniOtpremnicu.execute(otpremnica);
        return((IzmeniOtpremnicu)izmeniOtpremnicu).getOtpremnica();
    }

    public void obrisiOtpremnicu(Otpremnica otpremnica) throws Exception {
        AbstractGenericOperation obrisiOtp = new ObrisiOtpremnicu();
        obrisiOtp.execute(otpremnica);
    }

    public List<IDomainObject> vratiListuOtpremnica(Otpremnica otpremnica) throws Exception {
        AbstractGenericOperation vratiListuOtp = new VratiListuOtpremnica();
        vratiListuOtp.execute(otpremnica);
        return ((VratiListuOtpremnica)vratiListuOtp).getOtpremnice();
    }

    public Otpremnica vratiOtpremnicu(Otpremnica otpremnica) throws Exception {
        AbstractGenericOperation vratiOtpremnicu = new VratiOtpremnicu();
        vratiOtpremnicu.execute(otpremnica);
        return ((VratiOtpremnicu)vratiOtpremnicu).getOtpremnica();
    }

    public List<IDomainObject> vratiOtpremnicePoKriterijumu(Otpremnica otp) throws Exception {
        AbstractGenericOperation vratiOtp = new VratiOtpremnicePoKrit();
        vratiOtp.execute(otp);
        return ((VratiOtpremnicePoKrit)vratiOtp).getOtpremnice();
    }
}
