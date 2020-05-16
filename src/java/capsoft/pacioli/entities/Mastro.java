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
@Table(name = "mastro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mastro.findAll", query = "SELECT m FROM Mastro m"),
    @NamedQuery(name = "Mastro.findByCodiceMastro", query = "SELECT m FROM Mastro m WHERE m.codiceMastro = :codiceMastro"),
    @NamedQuery(name = "Mastro.findByDescrizioneMastro", query = "SELECT m FROM Mastro m WHERE m.descrizioneMastro = :descrizioneMastro")})
public class Mastro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codice_mastro")
    private String codiceMastro;
    @Size(max = 45)
    @Column(name = "descrizione_mastro")
    private String descrizioneMastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiceMastro")
    private Collection<Conto> contoCollection;
    @JoinColumn(name = "codice_tipologia_mastro", referencedColumnName = "codice_tipologia_mastro")
    @ManyToOne(optional = false)
    private TipologiaMastro codiceTipologiaMastro;

    public Mastro() {
    }

    public Mastro(String codiceMastro) {
        this.codiceMastro = codiceMastro;
    }

    public String getCodiceMastro() {
        return codiceMastro;
    }

    public void setCodiceMastro(String codiceMastro) {
        this.codiceMastro = codiceMastro;
    }

    public String getDescrizioneMastro() {
        return descrizioneMastro;
    }

    public void setDescrizioneMastro(String descrizioneMastro) {
        this.descrizioneMastro = descrizioneMastro;
    }

    @XmlTransient
    public Collection<Conto> getContoCollection() {
        return contoCollection;
    }

    public void setContoCollection(Collection<Conto> contoCollection) {
        this.contoCollection = contoCollection;
    }

    public TipologiaMastro getCodiceTipologiaMastro() {
        return codiceTipologiaMastro;
    }

    public void setCodiceTipologiaMastro(TipologiaMastro codiceTipologiaMastro) {
        this.codiceTipologiaMastro = codiceTipologiaMastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiceMastro != null ? codiceMastro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mastro)) {
            return false;
        }
        Mastro other = (Mastro) object;
        if ((this.codiceMastro == null && other.codiceMastro != null) || (this.codiceMastro != null && !this.codiceMastro.equals(other.codiceMastro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.pacioli.entities.Mastro[ codiceMastro=" + codiceMastro + " ]";
    }
    
}
