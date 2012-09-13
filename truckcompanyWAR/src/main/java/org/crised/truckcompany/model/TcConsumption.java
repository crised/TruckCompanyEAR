package org.crised.truckcompany.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tc_consumption")
public class TcConsumption extends GenericEntity {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consumption")
    private Integer id_consumption;
    
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
