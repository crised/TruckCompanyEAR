package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tc_user")
@NamedQueries({
    @NamedQuery(name = "TcUser.findAll", query = "SELECT t FROM TcUser t"),
    @NamedQuery(name = "TcUser.findById", query = "SELECT t FROM TcUser t WHERE t.id_user = :id"),
    @NamedQuery(name = "TcUser.findByUsername", query = "SELECT t FROM TcUser t WHERE t.username = :username"),
    @NamedQuery(name = "TcUser.findByPassword", query = "SELECT t FROM TcUser t WHERE t.password = :password")})

public class TcUser implements Serializable {
	
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer id_user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "password")
    private String password;

    public TcUser() {
    }

    public TcUser(Integer id) {
        this.id_user = id;
    }

    public TcUser(Integer id, String username, String password) {
        this.id_user = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id_user;
    }

    public void setId(Integer id) {
        this.id_user = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_user != null ? id_user.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TcUser)) {
            return false;
        }
        TcUser other = (TcUser) object;
        if ((this.id_user == null && other.id_user != null) || (this.id_user != null && !this.id_user.equals(other.id_user))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TcUser[ id=" + id_user + " ]";
    }
    
}
