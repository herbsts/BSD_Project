package bsd.school2017.boost_it.pkgDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import bsd.school2017.boost_it.pkgData.Unit;
import bsd.school2017.boost_it.pkgData.User;
import bsd.school2017.boost_it.pkgEnumerations.enumRole;
import bsd.school2017.boost_it.pkgWebService.AsyncUnit;
import bsd.school2017.boost_it.pkgWebService.AsyncUser;
import bsd.school2017.boost_it.pkgWebService.AsyncWord;

/**
 * Created by Martin on 23.11.2017.
 */

public class Database {
    private static Database instance = null;
    private User loggedInUser;
    private static final String URL = "http://localhost:8080/BoostIt/WS/";
    private static final String ContentType = "application/json";
    private AsyncUser asUser = null;
    private AsyncUnit asUnit = null;
    private AsyncWord asWord = null;
    private Gson gson;
    private ArrayList<User> allUsers = new ArrayList<>();
    private ArrayList<Unit> allUnits = new ArrayList<>();

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

    public static String getURL(){
        return URL;
    }

    public static String getContentType(){
        return ContentType;
    }

    public User getLoggedInUser() {
        return this.loggedInUser;
    }

    public boolean login(String username, String password) throws Exception {
        boolean isUser = false;
        loadAllUsers();
        for(User u : allUsers){
            if(u.getUsername().equals(username)){
                if(u.getPassword().equals(password)){
                    isUser = true;
                }
            }
        }
        return isUser;
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


    public void loadAllUsers() throws Exception{
        /*asUser = new AsyncUser();

        String paras[] = new String[2];
        paras[0] = "GET";
        paras[1] = "UserList";
        asUser.execute(paras);
        final String result = asUser.get();

        if(result == null){
            throw new Exception("webservice problem --getAllUsers");
        }

        Thread t = new Thread(new Runnable() {
            public void run() {
                Type userListType = new TypeToken<ArrayList<User>>(){}.getType();
                allUsers = gson.fromJson(result, userListType);
            }
        });


        t.start();
        t.join();*/

        allUsers.add(new User(1, "Sunny", "sunny", enumRole.ADMIN));
        allUsers.add(new User(2, "Lagger", "lagger", enumRole.USER));
    }

    public void loadUnits() throws Exception {
        asUnit = new AsyncUnit();

        String paras[] = new String[2];
        paras[0] = "GET";
        paras[1] = "UnitList";
        asUnit.execute(paras);
        final String result = asUnit.get();

        if(result == null){
            throw new Exception("webservice problem --getAllUsers");
        }

        Thread t = new Thread(new Runnable() {
            public void run() {
                Type unitListType = new TypeToken<ArrayList<User>>(){}.getType();
                allUnits = gson.fromJson(result, unitListType);
            }
        });
        t.start();
        t.join();
    }

    public ArrayList<Unit> getUnits() {
        allUnits.add(new Unit());
        return this.allUnits;
    }

    public String getTranslationEngToGer(String toTrans) throws Exception{
        asWord = new AsyncWord();

        String paras[] = new String[2];
        paras[0] = "GET";
        paras[1] = "WS/WordEnglish/";
        paras[2] = toTrans;
        asWord.execute(paras);
        final String result = asWord.get();

        if(result == null){
            throw new Exception("webservice problem --translate english");
        }
        System.out.println("******************" + result);
        return result;
    }

    public String getTranslationGerToEng(String toTrans) throws Exception{
        asWord = new AsyncWord();

        String paras[] = new String[2];
        paras[0] = "GET";
        paras[1] = "WS/WordGerman/";
        paras[2] = toTrans;
        asWord.execute(paras);
        final String result = asWord.get();

        if(result == null){
            throw new Exception("webservice problem --translate english");
        }
        System.out.println("******************" + result);
        return result;
    }
}
