package com.andepuc.Entity;

import com.andepuc.Entity.Ponto;
import com.andepuc.Entity.PontoUsuarioPK;
import com.andepuc.Entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-28T20:24:58")
@StaticMetamodel(PontoUsuario.class)
public class PontoUsuario_ { 

    public static volatile SingularAttribute<PontoUsuario, Usuario> usuario;
    public static volatile SingularAttribute<PontoUsuario, Ponto> ponto;
    public static volatile SingularAttribute<PontoUsuario, PontoUsuarioPK> pontoUsuarioPK;
    public static volatile SingularAttribute<PontoUsuario, String> comentario;

}