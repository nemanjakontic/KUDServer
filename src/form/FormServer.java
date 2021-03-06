/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import database.connection.Podesavanja;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import thread.ServerThreadd;

/**
 *
 * @author Nemanja
 */
public class FormServer extends javax.swing.JFrame {

    private boolean aktivan = true;
    private ServerThreadd nit;
    
    /**
     * Creates new form FormServer
     */
    public FormServer(java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
        initComponents();
        pripremi();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStatus = new javax.swing.JLabel();
        pnlPodaci = new javax.swing.JPanel();
        lblPort = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        lblURL = new javax.swing.JLabel();
        btnSacuvaj = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblStatus.setText("lblStatus");

        pnlPodaci.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblPort.setText("Port:");

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        lblURL.setText("URL:");

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPodaciLayout = new javax.swing.GroupLayout(pnlPodaci);
        pnlPodaci.setLayout(pnlPodaciLayout);
        pnlPodaciLayout.setHorizontalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(lblPort)
                        .addGap(18, 18, 18)
                        .addComponent(txtPort))
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(lblUsername)
                        .addGap(18, 18, 18)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(lblPassword)
                        .addGap(18, 18, 18)
                        .addComponent(txtPassword))
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(lblURL)
                        .addGap(18, 18, 18)
                        .addComponent(txtURL))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPodaciLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj)))
                .addContainerGap())
        );
        pnlPodaciLayout.setVerticalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblURL)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnStart.setText("Pokreni");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setText("Zaustavi");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStop))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus)
                .addGap(18, 18, 18)
                .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(btnStop))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try {
            startServer();
        } catch (IOException ex) {
            Logger.getLogger(FormServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        nit.stopServer();
        lblStatus.setText("Server nije pokrenut.");
        lblStatus.setForeground(Color.red);
        if (nit != null) {
            nit.sendShutDownMessage();
        }
        omoguci();
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
            validacija();
            Podesavanja.getInstance().setProperty("port", txtPort.getText());
            Podesavanja.getInstance().setProperty("url", txtURL.getText());
            Podesavanja.getInstance().setProperty("user", txtUsername.getText());
            Podesavanja.getInstance().setProperty("password", txtPassword.getText());
            JOptionPane.showMessageDialog(this, "Podaci su sacuvani", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblURL;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtURL;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    public void startServer() throws IOException, ClassNotFoundException {

        nit = new ServerThreadd();
        nit.start();
        onemoguci();
        lblStatus.setText("Server je pokrenut");
        lblStatus.setForeground(Color.GREEN);
    }

    private void pripremi() {
        lblStatus.setText("Server nije pokrenut.");
        lblStatus.setForeground(Color.red);
        String url = Podesavanja.getInstance().getProperty("url");
        String dbuser = Podesavanja.getInstance().getProperty("user");
        String dbpassword = Podesavanja.getInstance().getProperty("password");
        int port = Integer.parseInt(Podesavanja.getInstance().getProperty("port"));
        txtPort.setText(port + "");
        txtUsername.setText(dbuser);
        txtPassword.setText(dbpassword);
        txtURL.setText(url);
        btnStop.setEnabled(false);
    }

    private void zaustavi() {
        aktivan = false;
    }

    private void validacija() throws Exception {
        String url = txtURL.getText();
        String dbuser = txtUsername.getText();
        if (url.isEmpty() || dbuser.isEmpty()) {
            throw new Exception("Polja URL, username i port moraju biti popunjena!");
        }
        for (char ch : txtPort.getText().toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new Exception("Port mora biti ceo broj!");
            }
        }
        int port = Integer.parseInt(txtPort.getText());
        if (port < 2000) {
            throw new Exception("Port mora biti broj veci od 2000!");
        }
    }

    private void onemoguci() {
        txtUsername.setEnabled(false);
        txtPassword.setEnabled(false);
        txtURL.setEnabled(false);
        txtPort.setEnabled(false);
        btnSacuvaj.setEnabled(false);
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
    }

    private void omoguci() {
        txtUsername.setEnabled(true);
        txtPassword.setEnabled(true);
        txtURL.setEnabled(true);
        txtPort.setEnabled(true);
        btnSacuvaj.setEnabled(true);
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
    }
}
