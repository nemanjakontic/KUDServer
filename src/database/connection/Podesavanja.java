/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connection;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nemanja
 */
public class Podesavanja {
    private static Podesavanja instance;
    private Properties props;

    private Podesavanja() {
        try {
            props = new Properties();
            props.load(new FileInputStream("config/dbconfig.properties"));
        } catch (Exception ex) {
            Logger.getLogger(Podesavanja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Podesavanja getInstance() {
        if (instance == null) {
            instance = new Podesavanja();
        }
        return instance;
    }

    public String getProperty(String key) {
        return props.getProperty(key, "n/a");
    }
    
    public void setProperty(String key, String val) {
        props.setProperty(key, val);
    }
}
