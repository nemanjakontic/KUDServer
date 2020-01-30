/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import form.FormServer;

/**
 *
 * @author Nemanja
 */
public class Main {
    public static void main(String[] args) {
        FormServer fs = new FormServer(null, true);
        fs.setVisible(true);
    }
}
