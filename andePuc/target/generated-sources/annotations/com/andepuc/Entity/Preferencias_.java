package com.andepuc.Entity;

import com.andepuc.Entity.Ponto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-16T11:34:58")
@StaticMetamodel(Preferencias.class)
public class Preferencias_ { 

    public static volatile SingularAttribute<Preferencias, Integer> nroIntPref;
    public static volatile SingularAttribute<Preferencias, String> status;
    public static volatile SingularAttribute<Preferencias, Integer> valor;
    public static volatile ListAttribute<Preferencias, Ponto> pontoList;
    public static volatile SingularAttribute<Preferencias, String> nome;

}