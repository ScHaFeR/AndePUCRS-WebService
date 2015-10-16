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
@Table(name = "COMENTARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByNroIntComentario", query = "SELECT c FROM Comentario c WHERE c.nroIntComentario = :nroIntComentario"),
    @NamedQuery(name = "Comentario.findByLatitudeOrigem", query = "SELECT c FROM Comentario c WHERE c.latitudeOrigem = :latitudeOrigem"),
    @NamedQuery(name = "Comentario.findByLongitudeOrigem", query = "SELECT c FROM Comentario c WHERE c.longitudeOrigem = :longitudeOrigem"),
    @NamedQuery(name = "Comentario.findByLatitudeDestino", query = "SELECT c FROM Comentario c WHERE c.latitudeDestino = :latitudeDestino"),
    @NamedQuery(name = "Comentario.findByLongitudeDestino", query = "SELECT c FROM Comentario c WHERE c.longitudeDestino = :longitudeDestino"),
    @NamedQuery(name = "Comentario.findByComentario", query = "SELECT c FROM Comentario c WHERE c.comentario = :comentario")})
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_INT_COMENTARIO")
    private Integer nroIntComentario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LATITUDE_ORIGEM")
    private Double latitudeOrigem;
    @Column(name = "LONGITUDE_ORIGEM")
    private Double longitudeOrigem;
    @Column(name = "LATITUDE_DESTINO")
    private Double latitudeDestino;
    @Column(name = "LONGITUDE_DESTINO")
    private Double longitudeDestino;
    @Size(max = 1000)
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "NRO_INT_USUARIO", referencedColumnName = "NRO_INT_USUARIO")
    @ManyToOne
    private Usuario nroIntUsuario;

    public Comentario() {
    }

    public Comentario(Integer nroIntComentario) {
        this.nroIntComentario = nroIntComentario;
    }

    public Integer getNroIntComentario() {
        return nroIntComentario;
    }

    public void setNroIntComentario(Integer nroIntComentario) {
        this.nroIntComentario = nroIntComentario;
    }

    public Double getLatitudeOrigem() {
        return latitudeOrigem;
    }

    public void setLatitudeOrigem(Double latitudeOrigem) {
        this.latitudeOrigem = latitudeOrigem;
    }

    public Double getLongitudeOrigem() {
        return longitudeOrigem;
    }

    public void setLongitudeOrigem(Double longitudeOrigem) {
        this.longitudeOrigem = longitudeOrigem;
    }

    public Double getLatitudeDestino() {
        return latitudeDestino;
    }

    public void setLatitudeDestino(Double latitudeDestino) {
        this.latitudeDestino = latitudeDestino;
    }

    public Double getLongitudeDestino() {
        return longitudeDestino;
    }

    public void setLongitudeDestino(Double longitudeDestino) {
        this.longitudeDestino = longitudeDestino;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getNroIntUsuario() {
        return nroIntUsuario;
    }

    public void setNroIntUsuario(Usuario nroIntUsuario) {
        this.nroIntUsuario = nroIntUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroIntComentario != null ? nroIntComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.nroIntComentario == null && other.nroIntComentario != null) || (this.nroIntComentario != null && !this.nroIntComentario.equals(other.nroIntComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.Comentario[ nroIntComentario=" + nroIntComentario + " ]";
    }
    
}
