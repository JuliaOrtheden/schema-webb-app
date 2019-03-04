/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juliaortheden
 */
@Entity
@Table(name = "TIMESLOT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timeslot.findAll", query = "SELECT t FROM Timeslot t")
    , @NamedQuery(name = "Timeslot.findByDate", query = "SELECT t FROM Timeslot t WHERE t.timeslotPK.date = :date")
    , @NamedQuery(name = "Timeslot.findByTime", query = "SELECT t FROM Timeslot t WHERE t.timeslotPK.time = :time")
    , @NamedQuery(name = "Timeslot.findByRoom", query = "SELECT t FROM Timeslot t WHERE t.timeslotPK.room = :room")
    , @NamedQuery(name = "Timeslot.findByDescription", query = "SELECT t FROM Timeslot t WHERE t.description = :description")
    , @NamedQuery(name = "Timeslot.filterTimeslotByUser", query = "SELECT t FROM Timeslot t WHERE t.users.cid = :usercid")})
public class Timeslot implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TimeslotPK timeslotPK;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "ROOM", referencedColumnName = "NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Room room1;
    @JoinColumn(name = "USERS", referencedColumnName = "CID")
    @ManyToOne
    private Users users;

    public Timeslot() {
    }

    public Timeslot(TimeslotPK timeslotPK) {
        this.timeslotPK = timeslotPK;
    }

    public Timeslot(TimeslotPK timeslotPK, String description) {
        this.timeslotPK = timeslotPK;
        this.description = description;
    }

    public Timeslot(Date date, Date time, String room) {
        this.timeslotPK = new TimeslotPK(date, time, room);
    }

    public TimeslotPK getTimeslotPK() {
        return timeslotPK;
    }

    public void setTimeslotPK(TimeslotPK timeslotPK) {
        this.timeslotPK = timeslotPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timeslotPK != null ? timeslotPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timeslot)) {
            return false;
        }
        Timeslot other = (Timeslot) object;
        if ((this.timeslotPK == null && other.timeslotPK != null) || (this.timeslotPK != null && !this.timeslotPK.equals(other.timeslotPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SchemaApp2.com.Timeslot[ timeslotPK=" + timeslotPK + " ]";
    }
    
}
