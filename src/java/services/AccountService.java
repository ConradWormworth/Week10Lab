/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import database.UserDB;
import models.User;

/**
 *
 * @author awarsyle
 */
public class AccountService {

    public User login(String username, String password) {
        try {
            UserDB userDB = new UserDB();
            User user = userDB.getUser(username);

            if (user.getPassword().equals(password)) {
                return user;
            }
        } catch (Exception e) {

        }

        return null;
    }
}
