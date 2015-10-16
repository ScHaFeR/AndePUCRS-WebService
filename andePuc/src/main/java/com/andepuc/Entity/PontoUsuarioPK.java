/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andepuc.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Luis
 */
@Embeddable
public class PontoUsuarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_INT_PONTO")
    private int nroIntPonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NRO_INT_USUARIO")
    private int nroIntUsuario;

    public PontoUsuarioPK() {
    }

    public PontoUsuarioPK(int nroIntPonto, int nroIntUsuario) {
        this.nroIntPonto = nroIntPonto;
        this.nroIntUsuario = nroIntUsuario;
    }

    public int getNroIntPonto() {
        return nroIntPonto;
    }

    public void setNroIntPonto(int nroIntPonto) {
        this.nroIntPonto = nroIntPonto;
    }

    public int getNroIntUsuario() {
        return nroIntUsuario;
    }

    public void setNroIntUsuario(int nroIntUsuario) {
        this.nroIntUsuario = nroIntUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nroIntPonto;
        hash += (int) nroIntUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PontoUsuarioPK)) {
            return false;
        }
        PontoUsuarioPK other = (PontoUsuarioPK) object;
        if (this.nroIntPonto != other.nroIntPonto) {
            return false;
        }
        if (this.nroIntUsuario != other.nroIntUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.PontoUsuarioPK[ nroIntPonto=" + nroIntPonto + ", nroIntUsuario=" + nroIntUsuario + " ]";
    }
    
}
