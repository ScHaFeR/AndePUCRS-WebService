/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andepuc.WS;

import com.andepuc.ED.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("com.andepuc.ed.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {
    private final String funcaoHash = "SHA-256";
    private final String enconding = "UTF-8";
    
    @PersistenceContext(unitName = "com.andePuc_andePuc_war_1.0PU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity, Usuario usuario) {
        usuario.setNroIntUsuario(-1);
        
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance(funcaoHash);
            
                        
            // funcao hash sessao
            
            // senha informada pelo usuario + email + data/hora servidor
            String param = usuario.getHashSenha() + usuario.getEmail() + Calendar.getInstance().getTime();
            
            byte session[] = algorithm.digest(param.getBytes(enconding));
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : session) {
              hexString.append(String.format("%02X", 0xFF & b));
            }
            usuario.setSessionHash(hexString.toString());
            
            // Funcao hash senha usuario
            byte messageDigest[] = algorithm.digest(usuario.getHashSenha().getBytes(enconding));
            
            hexString = new StringBuilder();
            for (byte b : messageDigest) {
              hexString.append(String.format("%02X", 0xFF & b));
            }
            usuario.setHashSenha(hexString.toString());
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.create(entity, usuario);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
        super.edit(entity, entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id, Usuario usuario) {
        usuario.setNroIntUsuario(-1);
        super.remove(super.find(id, usuario), usuario);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public Usuario login(Usuario usuario) {
        Usuario usuarioVolta = (Usuario) getEntityManager().createNamedQuery("Usuario.findByEmail")
                                                                .setParameter("email", usuario.getEmail())
                                                                .getSingleResult();
        MessageDigest algorithm;
        try {
            algorithm = MessageDigest.getInstance(funcaoHash);

            // Funcao hash senha informada no login
            byte messageDigest[] = algorithm.digest(usuario.getHashSenha().getBytes(enconding));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
              hexString.append(String.format("%02X", 0xFF & b));
            }
            usuario.setHashSenha(hexString.toString());
            
            if(!usuario.getHashSenha().equals(usuarioVolta.getHashSenha())){
                throw new Exception("Senha incompativel");
            }
            
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // retorna o usuario cadastrado no banco, com o hash da sessao criado
        return usuarioVolta;
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Usuario> findAll( Usuario usuario) {
        usuario.setNroIntUsuario(-1);
        return null;
        //return super.findAll(usuario);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to,  Usuario usuario) {
        usuario.setNroIntUsuario(-1);
        return null;
        //return super.findRange(new int[]{from, to}, usuario);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST( Usuario usuario) {
        usuario.setNroIntUsuario(-1);
        return null;
        //return String.valueOf(super.count(usuario));
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
