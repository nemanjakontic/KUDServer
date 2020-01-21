/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.User;

/**
 *
 * @author Nemanja
 */
public interface ServiceUser {
    
     User login(User user) throws Exception;
    
}
