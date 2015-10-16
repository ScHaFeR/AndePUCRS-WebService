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
@Table(name = "TIPO_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT t FROM TipoUsuario t"),
    @NamedQuery(name = "TipoUsuario.findByNroIntTipoUsuario", query = "SELECT t FROM TipoUsuario t WHERE t.nroIntTipoUsuario = :nroIntTipoUsuario"),
    @NamedQuery(name = "TipoUsuario.findByDescricao", query = "SELECT t FROM TipoUsuario t WHERE t.descricao = :descricao")})
public class TipoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_INT_TIPO_USUARIO")
    private Integer nroIntTipoUsuario;
    @Size(max = 100)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(mappedBy = "nroIntTipoUsuario")
    private List<Usuario> usuarioList;

    public TipoUsuario() {
    }

    public TipoUsuario(Integer nroIntTipoUsuario) {
        this.nroIntTipoUsuario = nroIntTipoUsuario;
    }

    public Integer getNroIntTipoUsuario() {
        return nroIntTipoUsuario;
    }

    public void setNroIntTipoUsuario(Integer nroIntTipoUsuario) {
        this.nroIntTipoUsuario = nroIntTipoUsuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroIntTipoUsuario != null ? nroIntTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoUsuario)) {
            return false;
        }
        TipoUsuario other = (TipoUsuario) object;
        if ((this.nroIntTipoUsuario == null && other.nroIntTipoUsuario != null) || (this.nroIntTipoUsuario != null && !this.nroIntTipoUsuario.equals(other.nroIntTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.TipoUsuario[ nroIntTipoUsuario=" + nroIntTipoUsuario + " ]";
    }
    
}
