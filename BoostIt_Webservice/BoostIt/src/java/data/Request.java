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
public class Request {
    private int request_id;
    private Date requestDate;
    private Date editDate;
    private String status;
    private User user;
    
    public Request() {
        this(-99, Date.valueOf("1999-09-19"), Date.valueOf("1999-09-19"), "no status", new User());
    }

    public Request(int request_id, Date requestDate, Date editDate, String status, User user) {
        this.request_id = request_id;
        this.requestDate = requestDate;
        this.editDate = editDate;
        this.status = status;
        this.user = user;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
