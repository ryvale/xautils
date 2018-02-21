package com.exa.utils.values;

public class IntegerValue extends MemoryValue<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public IntegerValue() {
		super();
	}

	public IntegerValue(Integer value) {
		super(value);
	}

	@Override
	public IntegerValue asIntegerValue() {
		return this;
	}
	
	

}
