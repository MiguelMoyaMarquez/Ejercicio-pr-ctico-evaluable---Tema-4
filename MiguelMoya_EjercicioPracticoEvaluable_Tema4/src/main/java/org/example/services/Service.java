package org.example.services;

import org.example.models.Comentario;
import org.example.models.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static EntityManagerFactory emf;

    public Service(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public <T> void save(T entity){
        try{
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            em.persist(entity);

            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  <T> void  delete(T enty){
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            em.detach(enty);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Usuario> getUsuarios(){
        List<Usuario> salida = new ArrayList<>();
        try{
            EntityManager em = emf.createEntityManager();

            TypedQuery<Usuario> q = em.createQuery("SELECT u FROM Usuario u", Usuario.class);

            salida = q.getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }
    public  List<Comentario> getMejoresComentarios(int nota){
        List<Comentario> salida = new ArrayList<>();
        try{
            EntityManager em = emf.createEntityManager();

            TypedQuery<Comentario> q = em.createQuery("SELECT c FROM Comentario c WHERE c.valoracion>=:nota", Comentario.class);

            salida = q.getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }

    public Usuario getUsuario(String c){
        //Suponemos que el correo sera unico
        Usuario salida;
        try{
            EntityManager em = emf.createEntityManager();

            TypedQuery<Usuario> q = em.createQuery("SELECT u FROM Usuario u where u.correo=:c", Usuario.class);

            salida = q.getSingleResult();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }




}
