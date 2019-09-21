package com.exa.utils.values;

public class BooleanValue<_C> extends MemoryValue<Boolean, _C> {
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
	public BooleanValue<_C> asBooleanValue() {
		return this;
	}

	@Override
	public BooleanValue<_C> clone() /*throws CloneNotSupportedException*/ {
		return new BooleanValue<>(value);
	}

	@Override
	public String typeName() {
		return "boolean";
	}

}
