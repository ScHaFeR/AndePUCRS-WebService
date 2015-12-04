package com.andepuc.Entity;

import com.andepuc.Entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-28T20:24:58")
@StaticMetamodel(Comentario.class)
public class Comentario_ { 

    public static volatile SingularAttribute<Comentario, Usuario> nroIntUsuario;
    public static volatile SingularAttribute<Comentario, Double> latitudeOrigem;
    public static volatile SingularAttribute<Comentario, Integer> nroIntComentario;
    public static volatile SingularAttribute<Comentario, Integer> valor;
    public static volatile SingularAttribute<Comentario, Double> longitudeOrigem;
    public static volatile SingularAttribute<Comentario, Double> latitudeDestino;
    public static volatile SingularAttribute<Comentario, Double> longitudeDestino;
    public static volatile SingularAttribute<Comentario, String> comentario;

}