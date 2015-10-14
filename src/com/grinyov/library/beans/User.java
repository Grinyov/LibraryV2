package com.grinyov.library.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Grinyov Vitaliy on 14.10.15.
 *
 * Класс, отвечающий за пользователей системы
 *
 */

@ManagedBean
@SessionScoped
public class User implements Serializable{

    private String username;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}