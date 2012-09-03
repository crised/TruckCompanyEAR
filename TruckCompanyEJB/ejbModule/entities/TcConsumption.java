/*
 * 
 * 
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Kalyani Sakthivel <kalyani.sakthivel at yahoo.in>
 */
@Entity
@Table(name = "tc_consumption")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcConsumption.findAll", query = "SELECT t FROM TcConsumption t"),
    @NamedQuery(name = "TcConsumption.findById", query = "SELECT t FROM TcConsumption t WHERE t.id = :id"),
    @NamedQuery(name = "TcConsumption.findByConsumption", query = "SELECT t FROM TcConsumption t WHERE t.consumption = :consumption")})
public class TcConsumption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "consumption")
    private BigDecimal consumption;
    @JoinColumn(name = "truck_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TcTruck truckId;

    public TcConsumption() {
    }

    public TcConsumption(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public TcTruck getTruckId() {
        return truckId;
    }

    public void setTruckId(TcTruck truckId) {
        this.truckId = truckId;
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
        if (!(object instanceof TcConsumption)) {
            return false;
        }
        TcConsumption other = (TcConsumption) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TcConsumption[ id=" + id + " ]";
    }
    
}
