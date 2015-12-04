package com.andepuc.Entity;

import com.andepuc.Entity.Comentario;
import com.andepuc.Entity.PontoUsuario;
import com.andepuc.Entity.TipoUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-28T20:24:58")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Comentario> comentarioList;
    public static volatile SingularAttribute<Usuario, Integer> nroIntUsuario;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile ListAttribute<Usuario, PontoUsuario> pontoUsuarioList;
    public static volatile SingularAttribute<Usuario, String> hashSenha;
    public static volatile SingularAttribute<Usuario, String> nome;
    public static volatile SingularAttribute<Usuario, String> sessionHash;
    public static volatile SingularAttribute<Usuario, TipoUsuario> nroIntTipoUsuario;

}