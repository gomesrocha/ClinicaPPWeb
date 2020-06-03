/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.JPAUtils;
import infra.Paciente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Fabio Gomes Rocha
 */
@ManagedBean
@RequestScoped
public class PacienteBeans {

    /**
     * Creates a new instance of PacienteBeans
     */
    Paciente p = new Paciente();
    public PacienteBeans() {
    }
    public String salvarPaciente(){
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();
        em.close();
        emf.close();
        return "pacientes";
    }

    public Paciente getP() {
        return p;
    }

    public void setP(Paciente p) {
        this.p = p;
    }
    
    
}
