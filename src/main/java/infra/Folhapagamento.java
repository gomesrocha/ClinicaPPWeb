/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fabio
 */
@Entity
@Table(name = "folhapagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Folhapagamento.findAll", query = "SELECT f FROM Folhapagamento f"),
    @NamedQuery(name = "Folhapagamento.findById", query = "SELECT f FROM Folhapagamento f WHERE f.id = :id"),
    @NamedQuery(name = "Folhapagamento.findByNomeFuncionario", query = "SELECT f FROM Folhapagamento f WHERE f.nomeFuncionario = :nomeFuncionario"),
    @NamedQuery(name = "Folhapagamento.findBySalarioBruto", query = "SELECT f FROM Folhapagamento f WHERE f.salarioBruto = :salarioBruto"),
    @NamedQuery(name = "Folhapagamento.findByInss", query = "SELECT f FROM Folhapagamento f WHERE f.inss = :inss"),
    @NamedQuery(name = "Folhapagamento.findByIrrf", query = "SELECT f FROM Folhapagamento f WHERE f.irrf = :irrf"),
    @NamedQuery(name = "Folhapagamento.findBySalarioLiquido", query = "SELECT f FROM Folhapagamento f WHERE f.salarioLiquido = :salarioLiquido")})
public class Folhapagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nomeFuncionario")
    private String nomeFuncionario;
    @Basic(optional = false)
    @Column(name = "salarioBruto")
    private double salarioBruto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "inss")
    private Double inss;
    @Column(name = "irrf")
    private Double irrf;
    @Column(name = "salarioLiquido")
    private Double salarioLiquido;

    public Folhapagamento() {
    }

    public Folhapagamento(Integer id) {
        this.id = id;
    }

    public Folhapagamento(Integer id, String nomeFuncionario, double salarioBruto) {
        this.id = id;
        this.nomeFuncionario = nomeFuncionario;
        this.salarioBruto = salarioBruto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public Double getInss() {
        return inss;
    }

    public void setInss(Double inss) {
        this.inss = inss;
    }

    public Double getIrrf() {
        return irrf;
    }

    public void setIrrf(Double irrf) {
        this.irrf = irrf;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Folhapagamento)) {
            return false;
        }
        Folhapagamento other = (Folhapagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "infra.Folhapagamento[ id=" + id + " ]";
    }
    
}
