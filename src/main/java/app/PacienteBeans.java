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
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        return "pacientes";
    }

    public Paciente getP() {
        return p;
    }

    public void setP(Paciente p) {
        this.p = p;
    }
    
    
}
