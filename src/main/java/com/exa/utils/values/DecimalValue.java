package com.exa.utils.values;

public class DecimalValue extends MemoryValue<Double> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DecimalValue() {
		super();
	}

	public DecimalValue(Double value) {
		super(value);
	}
	
	@Override
	public DecimalValue asDecimalValue() {
		return this;
	}
}
