/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.Paciente;
import infra.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author fabio
 */
@ManagedBean
@RequestScoped
public class PacienteBean {
    Paciente paciente = new Paciente();
    /**
     * Creates a new instance of PacienteBean
     */
    public PacienteBean() {
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public void cadastrar(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(paciente);
        et.commit();
        em.close();
        emf.close();
    }
    
}
