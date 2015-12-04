/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andepuc.Service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Luis
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.andepuc.Service.AdminREST.class);
        resources.add(com.andepuc.Service.ComentarioREST.class);
        resources.add(com.andepuc.Service.EstabelecimentosREST.class);
        resources.add(com.andepuc.Service.MapREST.class);
        resources.add(com.andepuc.Service.PontoREST.class);
        resources.add(com.andepuc.Service.PontoUsuarioREST.class);
        resources.add(com.andepuc.Service.PreferenciasREST.class);
        resources.add(com.andepuc.Service.TipoEstabelecimentoREST.class);
        resources.add(com.andepuc.Service.TipoUsuarioREST.class);
        resources.add(com.andepuc.Service.UsuarioREST.class);
    }
    
}
