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
public class UserOwnsWord {
    private int id;
    private User user;
    private Word word;
    private Date lastTimeRevised;
    private float accuracy;

    public UserOwnsWord() {
        this(-99, new User(), new Word(), new Date(99), -99);
    }
    
    public UserOwnsWord(int id, User user, Word word, Date lastTimeRevised, float accuracy) {
        this.id = id;
        this.user = user;
        this.word = word;
        this.lastTimeRevised = lastTimeRevised;
        this.accuracy = accuracy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
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
