/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author schueler
 */
@XmlRootElement
public class UserBelongsTo {
    private User user;
    private User teacher;
    private String className;
    
    public UserBelongsTo() {
        this(new User(), new User(), "no class");
    }

    public UserBelongsTo(User user, User teacher, String className) {
        this.user = user;
        this.teacher = teacher;
        this.className = className;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
