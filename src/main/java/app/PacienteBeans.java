/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.JPAUtils;
import infra.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    private Paciente p = new Paciente();
    private List<Paciente> pacientes = new ArrayList<Paciente>();

    
    public PacienteBeans() {
    }
    public void selecionar(Paciente p){
        this.p = p;
    }
    public void excluir(Paciente p){
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        p = em.merge(p);
        em.remove(p);
        et.commit();
        em.close();
    }
    public String salvarPaciente(){
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(p);
        et.commit();
        em.close();
        return "cadPaciente"; 
    }

    public List<Paciente> getPacientes() {   
        EntityManager em = JPAUtils.getEntityManager();
        Query q = em.createQuery("select p from Paciente p", Paciente.class);
        List<Paciente> ps = q.getResultList();
        em.close();
        return ps;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public Paciente getP() {
        return p;
    }

    public void setP(Paciente p) {
        this.p = p;
    }
    
    
}
