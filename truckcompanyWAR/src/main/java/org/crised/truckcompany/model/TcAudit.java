package org.crised.truckcompany.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tc_audit")
public class TcAudit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum Action { CREATE, DELETE }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "action_name")
	private Action action;

	@Column(name = "create_date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id_user")    
	private TcUser user;

	@ManyToOne
	@JoinColumn(name = "consumption_id", referencedColumnName = "id_consumption")
	private TcConsumption consumption;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TcUser getUser() {
		return user;
	}

	public void setUser(TcUser user) {
		this.user = user;
	}

	public TcConsumption getConsumption() {
		return consumption;
	}

	public void setConsumption(TcConsumption consumption) {
		this.consumption = consumption;
	}
}
