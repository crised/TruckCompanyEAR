package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tc_truck")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TcTruck.findAll", query = "SELECT t FROM TcTruck t"),
    @NamedQuery(name = "TcTruck.findById", query = "SELECT t FROM TcTruck t WHERE t.id = :id"),
    @NamedQuery(name = "TcTruck.findByBrand", query = "SELECT t FROM TcTruck t WHERE t.brand = :brand"),
    @NamedQuery(name = "TcTruck.findByPlate", query = "SELECT t FROM TcTruck t WHERE t.plate = :plate")})
public class TcTruck implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "plate")
    private String plate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "truckId", fetch=FetchType.EAGER)
    private Collection<TcConsumption> tcConsumptionCollection;

    public TcTruck() {
    }

    public TcTruck(Integer id) {
        this.id = id;
    }

    public TcTruck(Integer id, String brand, String plate) {
        this.id = id;
        this.brand = brand;
        this.plate = plate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @XmlTransient
    public Collection<TcConsumption> getTcConsumptionCollection() {
        return tcConsumptionCollection;
    }

    public void setTcConsumptionCollection(Collection<TcConsumption> tcConsumptionCollection) {
        this.tcConsumptionCollection = tcConsumptionCollection;
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
        if (!(object instanceof TcTruck)) {
            return false;
        }
        TcTruck other = (TcTruck) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TcTruck[ id=" + id + " ]";
    }
    
}
