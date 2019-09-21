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

	@Override
	public IntegerValue<_C> clone() /*throws CloneNotSupportedException*/ {
		return new IntegerValue<>(value);
	}

	@Override
	public String toString() {
		if(value == null) return null;
		return value.toString();
	}

	@Override
	public String typeName() {
		return "int";
	}
	
	

}
