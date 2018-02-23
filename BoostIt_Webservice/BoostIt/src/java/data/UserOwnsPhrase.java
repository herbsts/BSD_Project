/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author schueler
 */
@XmlRootElement
public class UserOwnsPhrase {
    private int id;
    private Phrase phrase;
    private User user;
    private Date lastTimeRevised;
    private float accuracy;

    public UserOwnsPhrase() {
        this(-99, new Phrase(), new User(), Date.valueOf("1999-09-19"), -99);
    }
    
    public UserOwnsPhrase(int id, Phrase phrase, User user, Date lastTimeRevised, float accuracy) {
        this.id = id;
        this.phrase = phrase;
        this.user = user;
        this.lastTimeRevised = lastTimeRevised;
        this.accuracy = accuracy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Phrase getPhrase() {
        return phrase;
    }

    public void setPhrase(Phrase phrase) {
        this.phrase = phrase;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getLastTimeRevised() {
        return lastTimeRevised;
    }

    public void setLastTimeRevised(Date lastTimeRevised) {
        this.lastTimeRevised = lastTimeRevised;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }
    
}
