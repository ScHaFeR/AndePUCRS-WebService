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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "ESTABELECIMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estabelecimentos.findAll", query = "SELECT e FROM Estabelecimentos e"),
    @NamedQuery(name = "Estabelecimentos.findByNroIntEstabelecimento", query = "SELECT e FROM Estabelecimentos e WHERE e.nroIntEstabelecimento = :nroIntEstabelecimento"),
    @NamedQuery(name = "Estabelecimentos.findByNome", query = "SELECT e FROM Estabelecimentos e WHERE e.nome = :nome"),
    @NamedQuery(name = "Estabelecimentos.findByDescricao", query = "SELECT e FROM Estabelecimentos e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "Estabelecimentos.findByLatitude", query = "SELECT e FROM Estabelecimentos e WHERE e.latitude = :latitude"),
    @NamedQuery(name = "Estabelecimentos.findByLongitude", query = "SELECT e FROM Estabelecimentos e WHERE e.longitude = :longitude")})
public class Estabelecimentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_INT_ESTABELECIMENTO")
    private Integer nroIntEstabelecimento;
    @Size(max = 100)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 1000)
    @Column(name = "DESCRICAO")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LATITUDE")
    private Double latitude;
    @Column(name = "LONGITUDE")
    private Double longitude;
    @JoinColumn(name = "NRO_INT_TIPO_ESTABELECIMENTO", referencedColumnName = "NRO_INT_TIPO_ESTABELECIMENTO")
    @ManyToOne
    private TipoEstabelecimento nroIntTipoEstabelecimento;
    
    @Transient
    private Integer idTpEstabelecimento;

    public Estabelecimentos() {
    }

    public Estabelecimentos(Integer nroIntEstabelecimento) {
        this.nroIntEstabelecimento = nroIntEstabelecimento;
    }

    public Integer getNroIntEstabelecimento() {
        return nroIntEstabelecimento;
    }

    public void setNroIntEstabelecimento(Integer nroIntEstabelecimento) {
        this.nroIntEstabelecimento = nroIntEstabelecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public TipoEstabelecimento getNroIntTipoEstabelecimento() {
        return nroIntTipoEstabelecimento;
    }

    public void setNroIntTipoEstabelecimento(TipoEstabelecimento nroIntTipoEstabelecimento) {
        this.nroIntTipoEstabelecimento = nroIntTipoEstabelecimento;
    }
    
    public Integer getIdTpEstabelecimento(){
        return idTpEstabelecimento;
    }
    
    public void setIdTpEstabelecimento(Integer idTpEstabelecimento){
        this.idTpEstabelecimento = idTpEstabelecimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroIntEstabelecimento != null ? nroIntEstabelecimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estabelecimentos)) {
            return false;
        }
        Estabelecimentos other = (Estabelecimentos) object;
        if ((this.nroIntEstabelecimento == null && other.nroIntEstabelecimento != null) || (this.nroIntEstabelecimento != null && !this.nroIntEstabelecimento.equals(other.nroIntEstabelecimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.Estabelecimentos[ nroIntEstabelecimento=" + nroIntEstabelecimento + " ]";
    }
    
}
