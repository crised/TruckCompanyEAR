package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Class TcTruck.
 */
@Entity
@Table(name = "tc_truck")
public class TcTruck extends GenericEntity {
	
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5230737803158106265L;

	/** The id_truck. */
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tc_truck_seq")
    @SequenceGenerator(name = "tc_truck_seq", sequenceName = "tc_truck_seq", allocationSize=1)
    @Column(name = "id_truck")
    private Integer id_truck;
    
    /** The brand. */
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "brand")
    private String brand;
    
    /** The plate. */
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "plate")
    private String plate;

    /**
     * Instantiates a new tc truck.
     */
    public TcTruck() {
    }

    /**
     * Instantiates a new tc truck.
     *
     * @param id the id
     */
    public TcTruck(Integer id) {
        this.id_truck = id;
    }

    /**
     * Instantiates a new tc truck.
     *
     * @param id the id
     * @param brand the brand
     * @param plate the plate
     */
    public TcTruck(Integer id, String brand, String plate) {
        this.id_truck = id;
        this.brand = brand;
        this.plate = plate;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id_truck;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id_truck = id;
    }

    /**
     * Gets the brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand.
     *
     * @param brand the new brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the plate.
     *
     * @return the plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Sets the plate.
     *
     * @param plate the new plate
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "entities.TcTruck[ id=" + id_truck + " ]";
    }
}
