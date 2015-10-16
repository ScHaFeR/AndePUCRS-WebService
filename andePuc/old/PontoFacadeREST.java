/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andepuc.WS;

import com.andepuc.ED.Ponto;
import com.andepuc.ED.Usuario;
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

/**
 *
 * @author Luis
 */
@Stateless
@Path("com.andepuc.ed.ponto")
public class PontoFacadeREST extends AbstractFacade<Ponto> {
    @PersistenceContext(unitName = "com.andePuc_andePuc_war_1.0PU")
    private EntityManager em;

    public PontoFacadeREST() {
        super(Ponto.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Ponto entity, Usuario usuario) {
        super.create(entity, usuario);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Ponto entity, Usuario usuario) {
        super.edit(entity, usuario);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id, Usuario usuario) {
        super.remove(super.find(id, usuario), usuario);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Ponto find(@PathParam("id") Integer id, Usuario usuario) {
        return super.find(id, usuario);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Ponto> findAll(Usuario usuario) {
        return super.findAll(usuario);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Ponto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to, Usuario usuario) {
        return super.findRange(new int[]{from, to}, usuario);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST(Usuario usuario) {
        return String.valueOf(super.count(usuario));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
