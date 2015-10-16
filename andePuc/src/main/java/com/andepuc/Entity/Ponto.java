/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andepuc.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "PONTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ponto.findAll", query = "SELECT p FROM Ponto p"),
    @NamedQuery(name = "Ponto.findByNroIntPonto", query = "SELECT p FROM Ponto p WHERE p.nroIntPonto = :nroIntPonto"),
    @NamedQuery(name = "Ponto.findByDescricao", query = "SELECT p FROM Ponto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Ponto.findByStatus", query = "SELECT p FROM Ponto p WHERE p.status = :status"),
    @NamedQuery(name = "Ponto.findByLatitude", query = "SELECT p FROM Ponto p WHERE p.latitude = :latitude"),
    @NamedQuery(name = "Ponto.findByLongitude", query = "SELECT p FROM Ponto p WHERE p.longitude = :longitude")})
public class Ponto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_INT_PONTO")
    private Integer nroIntPonto;
    @Size(max = 200)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 100)
    @Column(name = "STATUS")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LATITUDE")
    private Double latitude;
    @Column(name = "LONGITUDE")
    private Double longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponto")
    private List<PontoUsuario> pontoUsuarioList;
    @JoinColumn(name = "NRO_INT_PREF", referencedColumnName = "NRO_INT_PREF")
    @ManyToOne
    private Preferencias nroIntPref;

    public Ponto() {
    }

    public Ponto(Integer nroIntPonto) {
        this.nroIntPonto = nroIntPonto;
    }

    public Integer getNroIntPonto() {
        return nroIntPonto;
    }

    public void setNroIntPonto(Integer nroIntPonto) {
        this.nroIntPonto = nroIntPonto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @XmlTransient
    public List<PontoUsuario> getPontoUsuarioList() {
        return pontoUsuarioList;
    }

    public void setPontoUsuarioList(List<PontoUsuario> pontoUsuarioList) {
        this.pontoUsuarioList = pontoUsuarioList;
    }

    public Preferencias getNroIntPref() {
        return nroIntPref;
    }

    public void setNroIntPref(Preferencias nroIntPref) {
        this.nroIntPref = nroIntPref;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroIntPonto != null ? nroIntPonto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ponto)) {
            return false;
        }
        Ponto other = (Ponto) object;
        if ((this.nroIntPonto == null && other.nroIntPonto != null) || (this.nroIntPonto != null && !this.nroIntPonto.equals(other.nroIntPonto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.Ponto[ nroIntPonto=" + nroIntPonto + " ]";
    }
    
}
