/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsd.school2017.boost_it.pkgData;

import java.sql.Date;


public class Request {
    private int request_id;
    private String concern;
    private Date requestDate;
    private Date editDate;
    private String status;
    private User user;
    
    public Request() {
        this(-99, "no concern", new Date(99), new Date(99), "no status", new User());
    }

    public Request(int request_id, String concern, Date requestDate, Date editDate, String status, User user) {
        this.request_id = request_id;
        this.concern = concern;
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

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
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
