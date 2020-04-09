/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.JPAUtils;
import infra.Medico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

/**
 *
 * @author fabio
 */
@ManagedBean
@RequestScoped
public class MedicoBeans {

    /**
     * Creates a new instance of MedicoBeans
     */
    private String nome, email;
    private Medico m = new Medico();
    public MedicoBeans() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void salvar(){
        m.setNome(nome);
        m.setEmail(email);
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
        
    }
    
    
}
