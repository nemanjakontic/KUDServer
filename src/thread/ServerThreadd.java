/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import database.connection.Podesavanja;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nemanja
 */
public class ServerThreadd extends Thread{
    private List<ClientThread> clients;
    private boolean aktivan = true;
    private ServerSocket serverSocket;

    public ServerThreadd() {
        this.clients = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(Integer.parseInt(Podesavanja.getInstance().getProperty("port")));
            System.out.println("Waiting for clients...");
            while (aktivan) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
                clients.add(clientThread);
            }
            
            /*for (ClientThread client : clients) {
                client.getSocket().close();
            }*/
            
        } catch (IOException ex) {
            System.out.println("Server je ugasen!");
        }
    }

    public void stopServer(){
        try {
            aktivan = false;
            serverSocket.close();
            clients.forEach(Thread::interrupt);
        } catch (IOException ex) {
            Logger.getLogger(ServerThreadd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendShutDownMessage(){
        for (ClientThread client : clients) {
            client.saljiKraj();
        }
    }
    
}
