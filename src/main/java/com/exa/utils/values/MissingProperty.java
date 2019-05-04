package com.exa.utils.values;

import com.exa.utils.ManagedException;

public class MissingProperty extends ManagedException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String property;

	public MissingProperty(String property) {
		this(property, String.format("The property %s is missing",  property));
	}
	
	public MissingProperty(String property, String message) {
		super(message);
		this.property = property;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
	

}
