package com.exa.utils.values;

public class IntegerValue<_C> extends MemoryValue<Integer, _C> {

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
	public IntegerValue<_C> asIntegerValue() {
		return this;
	}
	
	

}
