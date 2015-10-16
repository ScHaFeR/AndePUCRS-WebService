/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andepuc.Service;

import com.andepuc.Entity.PontoUsuario;
import com.andepuc.Entity.PontoUsuarioPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Luis
 */
@Stateless
@Path("com.andepuc.pontousuario")
public class PontoUsuarioREST extends AbstractFacade<PontoUsuario> {
    @PersistenceContext(unitName = "com.andePuc_andePuc_war_1.0PU")
    private EntityManager em;

    private PontoUsuarioPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;nroIntPonto=nroIntPontoValue;nroIntUsuario=nroIntUsuarioValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.andepuc.Entity.PontoUsuarioPK key = new com.andepuc.Entity.PontoUsuarioPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> nroIntPonto = map.get("nroIntPonto");
        if (nroIntPonto != null && !nroIntPonto.isEmpty()) {
            key.setNroIntPonto(new java.lang.Integer(nroIntPonto.get(0)));
        }
        java.util.List<String> nroIntUsuario = map.get("nroIntUsuario");
        if (nroIntUsuario != null && !nroIntUsuario.isEmpty()) {
            key.setNroIntUsuario(new java.lang.Integer(nroIntUsuario.get(0)));
        }
        return key;
    }

    public PontoUsuarioREST() {
        super(PontoUsuario.class);
    }

    @POST
    @Override
    @Consumes({ "application/json"})
    public void create(PontoUsuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({ "application/json"})
    public void edit(@PathParam("id") PathSegment id, PontoUsuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.andepuc.Entity.PontoUsuarioPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({ "application/json"})
    public PontoUsuario find(@PathParam("id") PathSegment id) {
        com.andepuc.Entity.PontoUsuarioPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({ "application/json"})
    public List<PontoUsuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ "application/json"})
    public List<PontoUsuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
