package com.andepuc.WS;

import java.util.List;
import com.andepuc.ED.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Luis
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity, Usuario usuario){
        try {
            validaUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getEntityManager().persist(entity);
    }

    public void edit(T entity, Usuario usuario){
        try {
            validaUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getEntityManager().merge(entity);
    }

    public void remove(T entity, Usuario usuario){
        try {
            validaUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id, Usuario usuario){
        try {
            validaUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll(Usuario usuario){
        try {
            validaUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range, Usuario usuario){
        try {
            validaUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count(Usuario usuario){
        try {
            validaUsuario(usuario);
        } catch (Exception ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public void validaUsuario(Usuario usuario) throws Exception{
        if(!usuario.getNroIntUsuario().equals(-1)){
            Usuario usuarioVolta = (Usuario) getEntityManager().createNamedQuery("Usuario.findByEmail")
                                                                    .setParameter("email", usuario.getEmail())
                                                                    .getSingleResult();
            if(usuarioVolta == null)
                throw new Exception("Usuario nao cadastrado");

            if(!usuarioVolta.getSessionHash().equals(usuario.getSessionHash()) ||
                    !usuarioVolta.getHashSenha().equals(usuario.getHashSenha())){
                throw new Exception("Usuario nao logado, hash incorreto.");
            }
        }
    }
    
}
