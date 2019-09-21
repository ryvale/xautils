package com.exa.utils.values;

public class DecimalValue<_C> extends MemoryValue<Double, _C> {
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
	public DecimalValue<_C> asDecimalValue() {
		return this;
	}

	@Override
	public DecimalValue<_C> clone() /*throws CloneNotSupportedException*/ {
		return new DecimalValue<>(value);
	}

	@Override
	public String typeName() {
		return "float";
	}
}
