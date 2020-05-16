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
@Table(name = "conto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conto.findAll", query = "SELECT c FROM Conto c"),
    @NamedQuery(name = "Conto.findByNumeroConto", query = "SELECT c FROM Conto c WHERE c.numeroConto = :numeroConto"),
    @NamedQuery(name = "Conto.findByDescrizioneConto", query = "SELECT c FROM Conto c WHERE c.descrizioneConto = :descrizioneConto")})
public class Conto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero_conto")
    private String numeroConto;
    @Size(max = 45)
    @Column(name = "descrizione_conto")
    private String descrizioneConto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroConto")
    private Collection<SottoConto> sottoContoCollection;
    @JoinColumn(name = "codice_mastro", referencedColumnName = "codice_mastro")
    @ManyToOne(optional = false)
    private Mastro codiceMastro;

    public Conto() {
    }

    public Conto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    public String getDescrizioneConto() {
        return descrizioneConto;
    }

    public void setDescrizioneConto(String descrizioneConto) {
        this.descrizioneConto = descrizioneConto;
    }

    @XmlTransient
    public Collection<SottoConto> getSottoContoCollection() {
        return sottoContoCollection;
    }

    public void setSottoContoCollection(Collection<SottoConto> sottoContoCollection) {
        this.sottoContoCollection = sottoContoCollection;
    }

    public Mastro getCodiceMastro() {
        return codiceMastro;
    }

    public void setCodiceMastro(Mastro codiceMastro) {
        this.codiceMastro = codiceMastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroConto != null ? numeroConto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conto)) {
            return false;
        }
        Conto other = (Conto) object;
        if ((this.numeroConto == null && other.numeroConto != null) || (this.numeroConto != null && !this.numeroConto.equals(other.numeroConto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.pacioli.entities.Conto[ numeroConto=" + numeroConto + " ]";
    }
    
}
