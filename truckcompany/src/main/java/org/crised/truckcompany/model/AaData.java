package org.crised.truckcompany.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "aaData")
public class AaData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7911622066754659038L;
	
	private Object aaData;

	public Object getAaData() {
		return aaData;
	}

	public void setAaData(Object aaData) {
		this.aaData = aaData;
	}
}
