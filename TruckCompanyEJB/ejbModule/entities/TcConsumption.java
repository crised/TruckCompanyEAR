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

@Entity
@Table(name = "tc_consumption")
@NamedQueries({
    @NamedQuery(name = "TcConsumption.findAll", query = "SELECT t FROM TcConsumption t"),
    @NamedQuery(name = "TcConsumption.findById", query = "SELECT t FROM TcConsumption t WHERE t.id_consumption = :id"),
    @NamedQuery(name = "TcConsumption.findByConsumption", query = "SELECT t FROM TcConsumption t WHERE t.consumption = :consumption")})
public class TcConsumption implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consumption")
    private Integer id_consumption;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "consumption")
    private BigDecimal consumption;
    @JoinColumn(name = "ctruck_id", referencedColumnName = "id_truck")
    @ManyToOne(optional = false)
    private TcTruck truckmap; //truckId refers to the complete entity!

    public TcConsumption() {
    }

    public TcConsumption(Integer id) {
        this.id_consumption = id;
    }

    public Integer getId() {
        return id_consumption;
    }

    public void setId(Integer id) {
        this.id_consumption = id;
    }

    public BigDecimal getConsumption() {
        return consumption;
    }

    public void setConsumption(BigDecimal consumption) {
        this.consumption = consumption;
    }

    public TcTruck gettruckmap() {
        return truckmap;
    }

    public void settruckmap(TcTruck truckId) {
        this.truckmap = truckId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_consumption != null ? id_consumption.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcConsumption)) {
            return false;
        }
        TcConsumption other = (TcConsumption) object;
        if ((this.id_consumption == null && other.id_consumption != null) || (this.id_consumption != null && !this.id_consumption.equals(other.id_consumption))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TcConsumption[ id=" + id_consumption + " ]";
    }
    
}
