/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SchemaApp2.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juliaortheden
 */
@Entity
@Table(name = "ROOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
    , @NamedQuery(name = "Room.findByName", query = "SELECT r FROM Room r WHERE r.name = :name")
    , @NamedQuery(name = "Room.findByType", query = "SELECT r FROM Room r WHERE r.type = :type")
    , @NamedQuery(name = "Room.findByMaxpeople", query = "SELECT r FROM Room r WHERE r.maxpeople = :maxpeople")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "MAXPEOPLE")
    private Short maxpeople;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room1")
    private Collection<Timeslot> timeslotCollection;

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Short getMaxpeople() {
        return maxpeople;
    }

    public void setMaxpeople(Short maxpeople) {
        this.maxpeople = maxpeople;
    }

    @XmlTransient
    public Collection<Timeslot> getTimeslotCollection() {
        return timeslotCollection;
    }

    public void setTimeslotCollection(Collection<Timeslot> timeslotCollection) {
        this.timeslotCollection = timeslotCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.SchemaApp2.com.Room[ name=" + name + " ]";
    }
    
}
