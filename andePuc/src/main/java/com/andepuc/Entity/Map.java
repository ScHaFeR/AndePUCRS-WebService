/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andepuc.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "MAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Map.findAll", query = "SELECT m FROM Map m"),
    @NamedQuery(name = "Map.findByNroIntMapa", query = "SELECT m FROM Map m WHERE m.nroIntMapa = :nroIntMapa"),
    @NamedQuery(name = "Map.findByX", query = "SELECT m FROM Map m WHERE m.x = :x"),
    @NamedQuery(name = "Map.findByY", query = "SELECT m FROM Map m WHERE m.y = :y"),
    @NamedQuery(name = "Map.findByLatitude", query = "SELECT m FROM Map m WHERE m.latitude = :latitude"),
    @NamedQuery(name = "Map.findByLongitude", query = "SELECT m FROM Map m WHERE m.longitude = :longitude"),
    @NamedQuery(name = "Map.findByValor", query = "SELECT m FROM Map m WHERE m.valor = :valor")})
public class Map implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_INT_MAPA")
    private Integer nroIntMapa;
    @Column(name = "X")
    private Integer x;
    @Column(name = "Y")
    private Integer y;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LATITUDE")
    private Double latitude;
    @Column(name = "LONGITUDE")
    private Double longitude;
    @Column(name = "VALOR")
    private Integer valor;

    public Map() {
    }

    public Map(Integer nroIntMapa) {
        this.nroIntMapa = nroIntMapa;
    }

    public Integer getNroIntMapa() {
        return nroIntMapa;
    }

    public void setNroIntMapa(Integer nroIntMapa) {
        this.nroIntMapa = nroIntMapa;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroIntMapa != null ? nroIntMapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Map)) {
            return false;
        }
        Map other = (Map) object;
        if ((this.nroIntMapa == null && other.nroIntMapa != null) || (this.nroIntMapa != null && !this.nroIntMapa.equals(other.nroIntMapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.Map[ nroIntMapa=" + nroIntMapa + " ]";
    }
    
}
