package bsd.school2017.boost_it.pkgData;

import java.io.Serializable;

/**
 * Created by Martin on 26.01.2018.
 */

public class Unit implements Serializable{
    private int id;
    private User creator;
    private String description;

    public Unit(){

    }

    public Unit(int id, User creator, String description){
        this.id = id;
        this.creator = creator;
        this.description = description;
    }

    public int getId(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public User getCreator(){
        return this.creator;
    }
}
