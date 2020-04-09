/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import infra.Paciente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Fabio Gomes Rocha
 */
public class PacienteRN implements Serializable {

    private static final long serialVersionUID = 1L;

    Paciente paciente = new Paciente();
    List<Paciente> pacientes;
    private EntityManager em;

    public PacienteRN() {
    }

    public PacienteRN(EntityManager em) {
        this.em = em;
    }
    
    public List<Paciente> pesquisar(String nome){
        String jpql = "from Paciente where nome like :nomePaciente";
        TypedQuery<Paciente> query = em.createQuery(jpql, Paciente.class);
        query.setParameter("nomePaciente", nome + "%");
        return query.getResultList();
    }
    public Paciente salvar(Paciente p){
        return em.merge(p);
    }
}
