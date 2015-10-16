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
@Table(name = "TIPO_ESTABELECIMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEstabelecimento.findAll", query = "SELECT t FROM TipoEstabelecimento t"),
    @NamedQuery(name = "TipoEstabelecimento.findByNroIntTipoEstabelecimento", query = "SELECT t FROM TipoEstabelecimento t WHERE t.nroIntTipoEstabelecimento = :nroIntTipoEstabelecimento"),
    @NamedQuery(name = "TipoEstabelecimento.findByDescricao", query = "SELECT t FROM TipoEstabelecimento t WHERE t.descricao = :descricao")})
public class TipoEstabelecimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_INT_TIPO_ESTABELECIMENTO")
    private Integer nroIntTipoEstabelecimento;
    @Size(max = 200)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(mappedBy = "nroIntTipoEstabelecimento")
    private List<Estabelecimentos> estabelecimentosList;

    public TipoEstabelecimento() {
    }

    public TipoEstabelecimento(Integer nroIntTipoEstabelecimento) {
        this.nroIntTipoEstabelecimento = nroIntTipoEstabelecimento;
    }

    public Integer getNroIntTipoEstabelecimento() {
        return nroIntTipoEstabelecimento;
    }

    public void setNroIntTipoEstabelecimento(Integer nroIntTipoEstabelecimento) {
        this.nroIntTipoEstabelecimento = nroIntTipoEstabelecimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Estabelecimentos> getEstabelecimentosList() {
        return estabelecimentosList;
    }

    public void setEstabelecimentosList(List<Estabelecimentos> estabelecimentosList) {
        this.estabelecimentosList = estabelecimentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroIntTipoEstabelecimento != null ? nroIntTipoEstabelecimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEstabelecimento)) {
            return false;
        }
        TipoEstabelecimento other = (TipoEstabelecimento) object;
        if ((this.nroIntTipoEstabelecimento == null && other.nroIntTipoEstabelecimento != null) || (this.nroIntTipoEstabelecimento != null && !this.nroIntTipoEstabelecimento.equals(other.nroIntTipoEstabelecimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.TipoEstabelecimento[ nroIntTipoEstabelecimento=" + nroIntTipoEstabelecimento + " ]";
    }
    
}
