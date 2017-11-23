package bsd.school2017.boost_it.pkgDatabase;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import bsd.school2017.boost_it.pkgData.User;

/**
 * Created by Martin on 23.11.2017.
 */

public class Database {
    private static Database instance = null;
    private User loggedInUser;

    public Database(){
        this.loggedInUser = null;
    }

    public void setLoggedInUser(User x){
        this.loggedInUser = x;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public User getLoggedInUser() {
        return this.loggedInUser;
    }

    public void login(String username, String password) throws Exception {
        //Launch login
        /*Accessor.runRequestAsync(HttpMethod.POST, "player/security/login", null,
                GsonSerializor.serializeLoginCredentials(new LoginCredentials(username, local_pwEnc)),
                new LoginHandler(username, local_pw_Unencrypted, listenersToInform, listenersToStore), 2000);*/
    }

    private String encryptPassword(String pwInput) {
        String hash = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pwInput.getBytes(), 0, pwInput.length());
            hash = new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash;
    }
}
