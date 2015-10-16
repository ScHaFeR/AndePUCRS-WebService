/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andepuc.Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PREFERENCIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preferencias.findAll", query = "SELECT p FROM Preferencias p"),
    @NamedQuery(name = "Preferencias.findByNroIntPref", query = "SELECT p FROM Preferencias p WHERE p.nroIntPref = :nroIntPref"),
    @NamedQuery(name = "Preferencias.findByNome", query = "SELECT p FROM Preferencias p WHERE p.nome = :nome"),
    @NamedQuery(name = "Preferencias.findByStatus", query = "SELECT p FROM Preferencias p WHERE p.status = :status"),
    @NamedQuery(name = "Preferencias.findByValor", query = "SELECT p FROM Preferencias p WHERE p.valor = :valor")})
public class Preferencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_INT_PREF")
    private Integer nroIntPref;
    @Size(max = 100)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 100)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "VALOR")
    private Integer valor;
    @OneToMany(mappedBy = "nroIntPref")
    private List<Ponto> pontoList;

    public Preferencias() {
    }

    public Preferencias(Integer nroIntPref) {
        this.nroIntPref = nroIntPref;
    }

    public Integer getNroIntPref() {
        return nroIntPref;
    }

    public void setNroIntPref(Integer nroIntPref) {
        this.nroIntPref = nroIntPref;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @XmlTransient
    public List<Ponto> getPontoList() {
        return pontoList;
    }

    public void setPontoList(List<Ponto> pontoList) {
        this.pontoList = pontoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroIntPref != null ? nroIntPref.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preferencias)) {
            return false;
        }
        Preferencias other = (Preferencias) object;
        if ((this.nroIntPref == null && other.nroIntPref != null) || (this.nroIntPref != null && !this.nroIntPref.equals(other.nroIntPref))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.Preferencias[ nroIntPref=" + nroIntPref + " ]";
    }
    
}
