package com.exa.utils.values;

public class StringValue extends Value<String> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public StringValue(String value) {
		super(value);
	}

	@Override
	public StringValue asStringValue() {
		return this;
	}

	@Override
	public String toString() {
		return value;
	}
	
}
