package com.andepuc.Entity;

import com.andepuc.Entity.PontoUsuario;
import com.andepuc.Entity.Preferencias;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-28T20:24:58")
@StaticMetamodel(Ponto.class)
public class Ponto_ { 

    public static volatile SingularAttribute<Ponto, Integer> nroIntPonto;
    public static volatile SingularAttribute<Ponto, Preferencias> nroIntPref;
    public static volatile SingularAttribute<Ponto, String> status;
    public static volatile SingularAttribute<Ponto, Integer> valor;
    public static volatile ListAttribute<Ponto, PontoUsuario> pontoUsuarioList;
    public static volatile SingularAttribute<Ponto, Double> longitude;
    public static volatile SingularAttribute<Ponto, Double> latitude;
    public static volatile SingularAttribute<Ponto, String> descricao;

}