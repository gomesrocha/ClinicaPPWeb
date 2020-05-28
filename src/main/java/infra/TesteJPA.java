/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author fabio
 */
public class TesteJPA {
    public static void main(String[] args) {
        //insert em JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        Usuario user = new Usuario();
        user.setEmail("joselito@email.com");
        user.setSenha("654321");
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(user);
        et.commit();
        em.close();
        emf.close();
                
    }
}
