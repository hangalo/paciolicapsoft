/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.pacioli.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "sotto_conto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SottoConto.findAll", query = "SELECT s FROM SottoConto s"),
    @NamedQuery(name = "SottoConto.findByNumeroSottoConto", query = "SELECT s FROM SottoConto s WHERE s.numeroSottoConto = :numeroSottoConto"),
    @NamedQuery(name = "SottoConto.findByDescrizioneSottoConto", query = "SELECT s FROM SottoConto s WHERE s.descrizioneSottoConto = :descrizioneSottoConto"),
    @NamedQuery(name = "SottoConto.findBySaldoIniziale", query = "SELECT s FROM SottoConto s WHERE s.saldoIniziale = :saldoIniziale")})
public class SottoConto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_sotto_conto")
    private String numeroSottoConto;
    @Size(max = 45)
    @Column(name = "descrizione_sotto_conto")
    private String descrizioneSottoConto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo_iniziale")
    private Double saldoIniziale;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroSottoConto")
    private Collection<MovimentoDettagli> movimentoDettagliCollection;
    @JoinColumn(name = "codice_centro_costo", referencedColumnName = "codice_centro_costo")
    @ManyToOne(optional = false)
    private CentroCosto codiceCentroCosto;
    @JoinColumn(name = "numero_conto", referencedColumnName = "numero_conto")
    @ManyToOne(optional = false)
    private Conto numeroConto;

    public SottoConto() {
    }

    public SottoConto(String numeroSottoConto) {
        this.numeroSottoConto = numeroSottoConto;
    }

    public String getNumeroSottoConto() {
        return numeroSottoConto;
    }

    public void setNumeroSottoConto(String numeroSottoConto) {
        this.numeroSottoConto = numeroSottoConto;
    }

    public String getDescrizioneSottoConto() {
        return descrizioneSottoConto;
    }

    public void setDescrizioneSottoConto(String descrizioneSottoConto) {
        this.descrizioneSottoConto = descrizioneSottoConto;
    }

    public Double getSaldoIniziale() {
        return saldoIniziale;
    }

    public void setSaldoIniziale(Double saldoIniziale) {
        this.saldoIniziale = saldoIniziale;
    }

    @XmlTransient
    public Collection<MovimentoDettagli> getMovimentoDettagliCollection() {
        return movimentoDettagliCollection;
    }

    public void setMovimentoDettagliCollection(Collection<MovimentoDettagli> movimentoDettagliCollection) {
        this.movimentoDettagliCollection = movimentoDettagliCollection;
    }

    public CentroCosto getCodiceCentroCosto() {
        return codiceCentroCosto;
    }

    public void setCodiceCentroCosto(CentroCosto codiceCentroCosto) {
        this.codiceCentroCosto = codiceCentroCosto;
    }

    public Conto getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(Conto numeroConto) {
        this.numeroConto = numeroConto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroSottoConto != null ? numeroSottoConto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SottoConto)) {
            return false;
        }
        SottoConto other = (SottoConto) object;
        if ((this.numeroSottoConto == null && other.numeroSottoConto != null) || (this.numeroSottoConto != null && !this.numeroSottoConto.equals(other.numeroSottoConto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.pacioli.entities.SottoConto[ numeroSottoConto=" + numeroSottoConto + " ]";
    }
    
}
