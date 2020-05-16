/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.pacioli.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "movimento_dettagli")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimentoDettagli.findAll", query = "SELECT m FROM MovimentoDettagli m"),
    @NamedQuery(name = "MovimentoDettagli.findByNumeroMovimentoDettagli", query = "SELECT m FROM MovimentoDettagli m WHERE m.numeroMovimentoDettagli = :numeroMovimentoDettagli"),
    @NamedQuery(name = "MovimentoDettagli.findByImportoDare", query = "SELECT m FROM MovimentoDettagli m WHERE m.importoDare = :importoDare"),
    @NamedQuery(name = "MovimentoDettagli.findByImportoAvere", query = "SELECT m FROM MovimentoDettagli m WHERE m.importoAvere = :importoAvere")})
public class MovimentoDettagli implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_movimento_dettagli")
    private Integer numeroMovimentoDettagli;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importo_dare")
    private Double importoDare;
    @Column(name = "importo_avere")
    private Double importoAvere;
    @JoinColumn(name = "numero_movimento", referencedColumnName = "numero_movimento")
    @ManyToOne(optional = false)
    private Movimento numeroMovimento;
    @JoinColumn(name = "numero_sotto_conto", referencedColumnName = "numero_sotto_conto")
    @ManyToOne(optional = false)
    private SottoConto numeroSottoConto;

    public MovimentoDettagli() {
    }

    public MovimentoDettagli(Integer numeroMovimentoDettagli) {
        this.numeroMovimentoDettagli = numeroMovimentoDettagli;
    }

    public Integer getNumeroMovimentoDettagli() {
        return numeroMovimentoDettagli;
    }

    public void setNumeroMovimentoDettagli(Integer numeroMovimentoDettagli) {
        this.numeroMovimentoDettagli = numeroMovimentoDettagli;
    }

    public Double getImportoDare() {
        return importoDare;
    }

    public void setImportoDare(Double importoDare) {
        this.importoDare = importoDare;
    }

    public Double getImportoAvere() {
        return importoAvere;
    }

    public void setImportoAvere(Double importoAvere) {
        this.importoAvere = importoAvere;
    }

    public Movimento getNumeroMovimento() {
        return numeroMovimento;
    }

    public void setNumeroMovimento(Movimento numeroMovimento) {
        this.numeroMovimento = numeroMovimento;
    }

    public SottoConto getNumeroSottoConto() {
        return numeroSottoConto;
    }

    public void setNumeroSottoConto(SottoConto numeroSottoConto) {
        this.numeroSottoConto = numeroSottoConto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroMovimentoDettagli != null ? numeroMovimentoDettagli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentoDettagli)) {
            return false;
        }
        MovimentoDettagli other = (MovimentoDettagli) object;
        if ((this.numeroMovimentoDettagli == null && other.numeroMovimentoDettagli != null) || (this.numeroMovimentoDettagli != null && !this.numeroMovimentoDettagli.equals(other.numeroMovimentoDettagli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.pacioli.entities.MovimentoDettagli[ numeroMovimentoDettagli=" + numeroMovimentoDettagli + " ]";
    }
    
}
