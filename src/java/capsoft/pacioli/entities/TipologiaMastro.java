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
@Table(name = "tipologia_mastro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipologiaMastro.findAll", query = "SELECT t FROM TipologiaMastro t"),
    @NamedQuery(name = "TipologiaMastro.findByCodiceTipologiaMastro", query = "SELECT t FROM TipologiaMastro t WHERE t.codiceTipologiaMastro = :codiceTipologiaMastro"),
    @NamedQuery(name = "TipologiaMastro.findByDescrizioneTipologiaMastro", query = "SELECT t FROM TipologiaMastro t WHERE t.descrizioneTipologiaMastro = :descrizioneTipologiaMastro")})
public class TipologiaMastro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codice_tipologia_mastro")
    private Integer codiceTipologiaMastro;
    @Size(max = 45)
    @Column(name = "descrizione_tipologia_mastro")
    private String descrizioneTipologiaMastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiceTipologiaMastro")
    private Collection<Mastro> mastroCollection;

    public TipologiaMastro() {
    }

    public TipologiaMastro(Integer codiceTipologiaMastro) {
        this.codiceTipologiaMastro = codiceTipologiaMastro;
    }

    public Integer getCodiceTipologiaMastro() {
        return codiceTipologiaMastro;
    }

    public void setCodiceTipologiaMastro(Integer codiceTipologiaMastro) {
        this.codiceTipologiaMastro = codiceTipologiaMastro;
    }

    public String getDescrizioneTipologiaMastro() {
        return descrizioneTipologiaMastro;
    }

    public void setDescrizioneTipologiaMastro(String descrizioneTipologiaMastro) {
        this.descrizioneTipologiaMastro = descrizioneTipologiaMastro;
    }

    @XmlTransient
    public Collection<Mastro> getMastroCollection() {
        return mastroCollection;
    }

    public void setMastroCollection(Collection<Mastro> mastroCollection) {
        this.mastroCollection = mastroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiceTipologiaMastro != null ? codiceTipologiaMastro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipologiaMastro)) {
            return false;
        }
        TipologiaMastro other = (TipologiaMastro) object;
        if ((this.codiceTipologiaMastro == null && other.codiceTipologiaMastro != null) || (this.codiceTipologiaMastro != null && !this.codiceTipologiaMastro.equals(other.codiceTipologiaMastro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.pacioli.entities.TipologiaMastro[ codiceTipologiaMastro=" + codiceTipologiaMastro + " ]";
    }
    
}
