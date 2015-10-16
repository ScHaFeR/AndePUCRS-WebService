/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andepuc.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "PONTO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PontoUsuario.findAll", query = "SELECT p FROM PontoUsuario p"),
    @NamedQuery(name = "PontoUsuario.findByNroIntPonto", query = "SELECT p FROM PontoUsuario p WHERE p.pontoUsuarioPK.nroIntPonto = :nroIntPonto"),
    @NamedQuery(name = "PontoUsuario.findByNroIntUsuario", query = "SELECT p FROM PontoUsuario p WHERE p.pontoUsuarioPK.nroIntUsuario = :nroIntUsuario"),
    @NamedQuery(name = "PontoUsuario.findByComentario", query = "SELECT p FROM PontoUsuario p WHERE p.comentario = :comentario")})
public class PontoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PontoUsuarioPK pontoUsuarioPK;
    @Size(max = 1000)
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "NRO_INT_PONTO", referencedColumnName = "NRO_INT_PONTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ponto ponto;
    @JoinColumn(name = "NRO_INT_USUARIO", referencedColumnName = "NRO_INT_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public PontoUsuario() {
    }

    public PontoUsuario(PontoUsuarioPK pontoUsuarioPK) {
        this.pontoUsuarioPK = pontoUsuarioPK;
    }

    public PontoUsuario(int nroIntPonto, int nroIntUsuario) {
        this.pontoUsuarioPK = new PontoUsuarioPK(nroIntPonto, nroIntUsuario);
    }

    public PontoUsuarioPK getPontoUsuarioPK() {
        return pontoUsuarioPK;
    }

    public void setPontoUsuarioPK(PontoUsuarioPK pontoUsuarioPK) {
        this.pontoUsuarioPK = pontoUsuarioPK;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pontoUsuarioPK != null ? pontoUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PontoUsuario)) {
            return false;
        }
        PontoUsuario other = (PontoUsuario) object;
        if ((this.pontoUsuarioPK == null && other.pontoUsuarioPK != null) || (this.pontoUsuarioPK != null && !this.pontoUsuarioPK.equals(other.pontoUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.PontoUsuario[ pontoUsuarioPK=" + pontoUsuarioPK + " ]";
    }
    
}
