/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import domain.Clan;
import domain.IDomainObject;
import domain.Nosnja;
import domain.Otpremnica;
import domain.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ServiceClan;
import service.ServiceNosnja;
import service.ServiceOtpremnica;
import service.ServiceUser;
import service.impl.ServiceClanImpl;
import service.impl.ServiceNosnjaImpl;
import service.impl.ServiceOtpremnicaImpl;
import service.impl.ServiceUserImpl;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.Operation;
import util.ResponseStatus;

/**
 *
 * @author Nemanja
 */
public class ClientThread extends Thread {

    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;
    private final ServiceClan serviceClan;
    private final ServiceUser serviceUser;
    private final ServiceNosnja serviceNosnja;
    private final ServiceOtpremnica serviceOtpremnica;

    private User loginUser;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        serviceClan = new ServiceClanImpl();
        serviceUser = new ServiceUserImpl();
        serviceNosnja = new ServiceNosnjaImpl();
        serviceOtpremnica = new ServiceOtpremnicaImpl();
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                RequestObject requestObject = (RequestObject) objectInputStream.readObject();
                ResponseObject responseObject = handleRequest(requestObject);
                objectOutputStream.writeObject(responseObject);
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public User getLoginUser() {
        return loginUser;
    }

    private ResponseObject handleRequest(RequestObject requestObject) {
        int operation = requestObject.getOperation();
        switch (operation) {
            case Operation.LOGIN:
                return login((User) requestObject.getData());
            case Operation.SAVE_CLAN:
                return saveClan((Clan) requestObject.getData());
            case Operation.VRATI_JEDNOG_CLANA:
                return vratiClana((Clan) requestObject.getData());
            case Operation.VRATI_SVЕ_CLANOVE:
                return vratiSveClanove((List<Clan>) requestObject.getData());
            case Operation.VRATI_CLANOVE_PO_KRITERIJUMU:
                return vratiClanovePoKrit((Clan) requestObject.getData());
            case Operation.OBRISI_CLANA:
                return obrisiClana((Clan)requestObject.getData());
            case Operation.IZMENI_CLANA:
                return izmeniClana((Clan)requestObject.getData());
            case Operation.SAVE_NOSNJA:
                return sacuvajNosnju((Nosnja)requestObject.getData());
            case Operation.OBRISI_NOSNJU:
                return obrisiNosnju((Nosnja)requestObject.getData());
            case Operation.IZMENI_NOSNJU:
                return izmeniNosnju((Nosnja)requestObject.getData());
            case Operation.VRATI_JEDNU_NOSNJU:
                return vratiNosnju((Nosnja)requestObject.getData());
            case Operation.VRATI_SVЕ_NOSNJE:
                return vratiSveNosnje((List<Nosnja>)requestObject.getData());
            case Operation.VRATI_NOSNJE_PO_KRITERIJUMU:
                return vratiNosnjePoKrt((Nosnja)requestObject.getData());
            case Operation.SAVE_OTPREMNICA:
                return sacuvajOtpremnicu((Otpremnica)requestObject.getData());
            case Operation.IZMENI_OTPREMNICU:
                return izmeniOtpremnicu((Otpremnica)requestObject.getData());
            case Operation.OBRISI_OTPREMNICU:
                return obrisiOtpremnicu((Otpremnica)requestObject.getData());
            case Operation.VRATI_SVЕ_OTPREMNICE:
                return vratiSveOtpremnice();
            case Operation.VRATI_JEDNU_OTPREMNICE:
                return vratiJednuOtp((Otpremnica)requestObject.getData());
            case Operation.VRATI_OTPREMNICE_PO_KRITERIJUMU:
                return vratiOtpPoKrt((Otpremnica)requestObject.getData());
        }
        return null;
    }

    private ResponseObject saveClan(Clan clan) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Clan c = serviceClan.zapamtiCl(clan);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(c);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject login(User user1) {
        /*String username = (String) data.get("username");
        String password = (String) data.get("password");*/
        ResponseObject responseObject = new ResponseObject();
        try {
            User user = serviceUser.login(user1);
            responseObject.setData(user);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            loginUser = user;
        } catch (Exception ex) {
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }

        return responseObject;
    }

    private ResponseObject vratiClana(Clan data) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Clan c = serviceClan.vratiCl(data);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(c);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject vratiSveClanove(List<Clan> list) {
        ResponseObject responseObject = new ResponseObject();
        try {
            List<IDomainObject> clanovi = serviceClan.vratiListuCl();
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(clanovi);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject vratiClanovePoKrit(Clan clan) {
        /*String sifra = (String) map.get("sifra");
        String ime = (String) map.get("ime");
        String prezime = (String) map.get("prezime");*/
        ResponseObject responseObject = new ResponseObject();
        try {
            List<IDomainObject> clanovi = serviceClan.vratiClanovePoKriterijumu(clan);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(clanovi);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject obrisiClana(Clan clan) {
        ResponseObject responseObject = new ResponseObject();
        try {
            serviceClan.obrisiCl(clan);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject izmeniClana(Clan clan) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Clan c = serviceClan.izmeniCl(clan);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(c);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject sacuvajNosnju(Nosnja nosnja) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Nosnja n = serviceNosnja.sacuvajNo(nosnja);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(n);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject obrisiNosnju(Nosnja nosnja) {
        ResponseObject responseObject = new ResponseObject();
        try {
            serviceNosnja.obrisiNo(nosnja);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject izmeniNosnju(Nosnja nosnja) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Nosnja n = serviceNosnja.izmeniNo(nosnja);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(n);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject vratiNosnju(Nosnja nosnja) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Nosnja n = serviceNosnja.vratiNo(nosnja);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(n);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject vratiSveNosnje(List<Nosnja> list) {
        ResponseObject responseObject = new ResponseObject();
        try {
            List<IDomainObject> nosnje = serviceNosnja.vratiListuNo();
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(nosnje);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject vratiNosnjePoKrt(Nosnja nosnja) {
        /*String sifra1 = (String) map.get("sifraNosnje");
        String naziv = (String) map.get("naziv");
        String vrsta = (String) map.get("vrsta");*/
        ResponseObject responseObject = new ResponseObject();
        try {
            List<IDomainObject> nosnje = serviceNosnja.vratiNosnjePoKrit(nosnja);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(nosnje);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject sacuvajOtpremnicu(Otpremnica otpremnica) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Otpremnica otp = serviceOtpremnica.sacuvajOt(otpremnica);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(otp);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject izmeniOtpremnicu(Otpremnica otpremnica) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Otpremnica otp = serviceOtpremnica.izmeniOtpremnicu(otpremnica);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(otp);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject obrisiOtpremnicu(Otpremnica otpremnica) {
        ResponseObject responseObject = new ResponseObject();
        try {
            serviceOtpremnica.obrisiOtp(otpremnica);
            responseObject.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject vratiSveOtpremnice() {
        ResponseObject responseObject = new ResponseObject();
        try {
            List<IDomainObject> otpremnice = serviceOtpremnica.vratiOt();
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(otpremnice);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject vratiJednuOtp(Otpremnica otpremnica) {
        ResponseObject responseObject = new ResponseObject();
        try {
            Otpremnica otp = serviceOtpremnica.vratiOt(otpremnica);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(otp);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

    private ResponseObject vratiOtpPoKrt(Otpremnica otp) {
        /*String sifra1 = (String) map.get("sifra");
        String clan = (String) map.get("clan");*/
        ResponseObject responseObject = new ResponseObject();
        try {
            List<IDomainObject> otpremnice = serviceOtpremnica.vratiOtpPoKrt(otp);
            responseObject.setStatus(ResponseStatus.SUCCESS);
            responseObject.setData(otpremnice);
        } catch (Exception ex) {
            ex.printStackTrace();
            responseObject.setStatus(ResponseStatus.ERROR);
            responseObject.setErrorMessage(ex.getMessage());
        }
        return responseObject;
    }

}
