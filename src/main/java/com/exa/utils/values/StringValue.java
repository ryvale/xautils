package com.exa.utils.values;

public class StringValue<_C>  extends MemoryValue<String, _C> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public StringValue(String value) {
		super(value);
	}

	@Override
	public StringValue<_C> asStringValue() {
		return this;
	}

	@Override
	public String toString() {
		return value;
	}
	
}
