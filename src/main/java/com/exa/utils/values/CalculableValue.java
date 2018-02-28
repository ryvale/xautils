package com.exa.utils.values;

public class CalculableValue extends StringValue {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String expType;
	
	public CalculableValue(String value, String expType) {
		super(value);
		
	}

	@Override
	public CalculableValue asCalculableValue() {
		return this;
	}
	
	public String expType() { return expType; }

}
