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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNroIntUsuario", query = "SELECT u FROM Usuario u WHERE u.nroIntUsuario = :nroIntUsuario"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByHashSenha", query = "SELECT u FROM Usuario u WHERE u.hashSenha = :hashSenha"),
    @NamedQuery(name = "Usuario.findBySessionHash", query = "SELECT u FROM Usuario u WHERE u.sessionHash = :sessionHash")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_INT_USUARIO")
    private Integer nroIntUsuario;
    @Size(max = 200)
    @Column(name = "NOME")
    private String nome;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 200)
    @Column(name = "HASH_SENHA")
    private String hashSenha;
    @Size(max = 256)
    @Column(name = "SESSION_HASH")
    private String sessionHash;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<PontoUsuario> pontoUsuarioList;
    @OneToMany(mappedBy = "nroIntUsuario")
    private List<Comentario> comentarioList;
    @JoinColumn(name = "NRO_INT_TIPO_USUARIO", referencedColumnName = "NRO_INT_TIPO_USUARIO")
    @ManyToOne
    private TipoUsuario nroIntTipoUsuario;

    public Usuario() {
    }

    public Usuario(Integer nroIntUsuario) {
        this.nroIntUsuario = nroIntUsuario;
    }

    public Integer getNroIntUsuario() {
        return nroIntUsuario;
    }

    public void setNroIntUsuario(Integer nroIntUsuario) {
        this.nroIntUsuario = nroIntUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    public String getSessionHash() {
        return sessionHash;
    }

    public void setSessionHash(String sessionHash) {
        this.sessionHash = sessionHash;
    }

    @XmlTransient
    public List<PontoUsuario> getPontoUsuarioList() {
        return pontoUsuarioList;
    }

    public void setPontoUsuarioList(List<PontoUsuario> pontoUsuarioList) {
        this.pontoUsuarioList = pontoUsuarioList;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    public TipoUsuario getNroIntTipoUsuario() {
        return nroIntTipoUsuario;
    }

    public void setNroIntTipoUsuario(TipoUsuario nroIntTipoUsuario) {
        this.nroIntTipoUsuario = nroIntTipoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroIntUsuario != null ? nroIntUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nroIntUsuario == null && other.nroIntUsuario != null) || (this.nroIntUsuario != null && !this.nroIntUsuario.equals(other.nroIntUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andepuc.Entity.Usuario[ nroIntUsuario=" + nroIntUsuario + " ]";
    }
    
}
