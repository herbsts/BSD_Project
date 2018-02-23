package bsd.school2017.boost_it.pkgData;

import java.io.Serializable;

import bsd.school2017.boost_it.pkgEnumerations.enumRole;

/**
 * Created by Martin on 23.11.2017.
 */

public class User implements Serializable {
    private int user_id;
    private String username;
    private enumRole role;
    private String password;

    public User(int user_id, String username, String password, enumRole role){
        this.user_id = user_id;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public User(){

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public enumRole getRole() {
        return role;
    }

    public void setRole(enumRole role) {
        this.role = role;
    }

    public String getPassword() { return password; }
}

