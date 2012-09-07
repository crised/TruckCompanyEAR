package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tc_truck")
public class TcTruck extends GenericEntity {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_truck")
    private Integer id_truck;
    
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "brand")
    private String brand;
    
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "plate")
    private String plate;

    public TcTruck() {
    }

    public TcTruck(Integer id) {
        this.id_truck = id;
    }

    public TcTruck(Integer id, String brand, String plate) {
        this.id_truck = id;
        this.brand = brand;
        this.plate = plate;
    }

    public Integer getId() {
        return id_truck;
    }

    public void setId(Integer id) {
        this.id_truck = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_truck != null ? id_truck.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcTruck)) {
            return false;
        }
        TcTruck other = (TcTruck) object;
        if ((this.id_truck == null && other.id_truck != null) || (this.id_truck != null && !this.id_truck.equals(other.id_truck))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TcTruck[ id=" + id_truck + " ]";
    }
}
