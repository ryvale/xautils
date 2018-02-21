package com.exa.utils.values;

public class BooleanValue extends MemoryValue<Boolean> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BooleanValue() {
		super();
	}

	public BooleanValue(Boolean value) {
		super(value);
	}

	@Override
	public BooleanValue asBooleanValue() {
		return this;
	}
	
	

}
