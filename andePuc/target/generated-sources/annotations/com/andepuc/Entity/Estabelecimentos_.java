package com.andepuc.Entity;

import com.andepuc.Entity.TipoEstabelecimento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-16T11:34:58")
@StaticMetamodel(Estabelecimentos.class)
public class Estabelecimentos_ { 

    public static volatile SingularAttribute<Estabelecimentos, Integer> nroIntEstabelecimento;
    public static volatile SingularAttribute<Estabelecimentos, TipoEstabelecimento> nroIntTipoEstabelecimento;
    public static volatile SingularAttribute<Estabelecimentos, String> nome;
    public static volatile SingularAttribute<Estabelecimentos, Double> longitude;
    public static volatile SingularAttribute<Estabelecimentos, Double> latitude;
    public static volatile SingularAttribute<Estabelecimentos, String> descricao;

}