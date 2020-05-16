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
@Table(name = "centro_costo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CentroCosto.findAll", query = "SELECT c FROM CentroCosto c"),
    @NamedQuery(name = "CentroCosto.findByCodiceCentroCosto", query = "SELECT c FROM CentroCosto c WHERE c.codiceCentroCosto = :codiceCentroCosto"),
    @NamedQuery(name = "CentroCosto.findByDescrizioneCentroCosto", query = "SELECT c FROM CentroCosto c WHERE c.descrizioneCentroCosto = :descrizioneCentroCosto")})
public class CentroCosto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codice_centro_costo")
    private Integer codiceCentroCosto;
    @Size(max = 45)
    @Column(name = "descrizione_centro_costo")
    private String descrizioneCentroCosto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codiceCentroCosto")
    private Collection<SottoConto> sottoContoCollection;

    public CentroCosto() {
    }

    public CentroCosto(Integer codiceCentroCosto) {
        this.codiceCentroCosto = codiceCentroCosto;
    }

    public Integer getCodiceCentroCosto() {
        return codiceCentroCosto;
    }

    public void setCodiceCentroCosto(Integer codiceCentroCosto) {
        this.codiceCentroCosto = codiceCentroCosto;
    }

    public String getDescrizioneCentroCosto() {
        return descrizioneCentroCosto;
    }

    public void setDescrizioneCentroCosto(String descrizioneCentroCosto) {
        this.descrizioneCentroCosto = descrizioneCentroCosto;
    }

    @XmlTransient
    public Collection<SottoConto> getSottoContoCollection() {
        return sottoContoCollection;
    }

    public void setSottoContoCollection(Collection<SottoConto> sottoContoCollection) {
        this.sottoContoCollection = sottoContoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiceCentroCosto != null ? codiceCentroCosto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentroCosto)) {
            return false;
        }
        CentroCosto other = (CentroCosto) object;
        if ((this.codiceCentroCosto == null && other.codiceCentroCosto != null) || (this.codiceCentroCosto != null && !this.codiceCentroCosto.equals(other.codiceCentroCosto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.pacioli.entities.CentroCosto[ codiceCentroCosto=" + codiceCentroCosto + " ]";
    }
    
}
