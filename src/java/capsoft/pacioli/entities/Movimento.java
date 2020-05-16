/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoft.pacioli.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author informatica
 */
@Entity
@Table(name = "movimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m"),
    @NamedQuery(name = "Movimento.findByNumeroMovimento", query = "SELECT m FROM Movimento m WHERE m.numeroMovimento = :numeroMovimento"),
    @NamedQuery(name = "Movimento.findByDataMovimento", query = "SELECT m FROM Movimento m WHERE m.dataMovimento = :dataMovimento"),
    @NamedQuery(name = "Movimento.findByDescrizioneMovimento", query = "SELECT m FROM Movimento m WHERE m.descrizioneMovimento = :descrizioneMovimento"),
    @NamedQuery(name = "Movimento.findByNotaMovimento", query = "SELECT m FROM Movimento m WHERE m.notaMovimento = :notaMovimento")})
public class Movimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_movimento")
    private Integer numeroMovimento;
    @Column(name = "data_movimento")
    @Temporal(TemporalType.DATE)
    private Date dataMovimento;
    @Size(max = 45)
    @Column(name = "descrizione_movimento")
    private String descrizioneMovimento;
    @Size(max = 45)
    @Column(name = "nota_movimento")
    private String notaMovimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroMovimento")
    private Collection<MovimentoDettagli> movimentoDettagliCollection;

    public Movimento() {
    }

    public Movimento(Integer numeroMovimento) {
        this.numeroMovimento = numeroMovimento;
    }

    public Integer getNumeroMovimento() {
        return numeroMovimento;
    }

    public void setNumeroMovimento(Integer numeroMovimento) {
        this.numeroMovimento = numeroMovimento;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public String getDescrizioneMovimento() {
        return descrizioneMovimento;
    }

    public void setDescrizioneMovimento(String descrizioneMovimento) {
        this.descrizioneMovimento = descrizioneMovimento;
    }

    public String getNotaMovimento() {
        return notaMovimento;
    }

    public void setNotaMovimento(String notaMovimento) {
        this.notaMovimento = notaMovimento;
    }

    @XmlTransient
    public Collection<MovimentoDettagli> getMovimentoDettagliCollection() {
        return movimentoDettagliCollection;
    }

    public void setMovimentoDettagliCollection(Collection<MovimentoDettagli> movimentoDettagliCollection) {
        this.movimentoDettagliCollection = movimentoDettagliCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroMovimento != null ? numeroMovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.numeroMovimento == null && other.numeroMovimento != null) || (this.numeroMovimento != null && !this.numeroMovimento.equals(other.numeroMovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "capsoft.pacioli.entities.Movimento[ numeroMovimento=" + numeroMovimento + " ]";
    }
    
}
