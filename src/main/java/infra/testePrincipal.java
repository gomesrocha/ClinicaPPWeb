/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author fabio
 */
public class testePrincipal {
    public static void main(String[] args) {
        Usuario usrfinal = new Usuario();
        // Consulta em JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();       
        
        Query q = em.createQuery("select u from Usuario u", Usuario.class);
        List<Usuario> usuarios = q.getResultList();
        
        for(Usuario user: usuarios){
            System.out.println(user.getIdusuario());
            System.out.println(user.getEmail());
            usrfinal = user;
        }
        //removendo objeto do banco de dados
        /*
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(usrfinal);
        et.commit();*/
        //atualizando objeto no banco de dados
        usrfinal.setEmail("fabio_gomes@souunit.com.br");
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(usrfinal);
        et.commit();
        em.close();
        emf.close();
    }
}
