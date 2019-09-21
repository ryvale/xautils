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

	@Override
	public StringValue<_C> clone() /*throws CloneNotSupportedException*/ {
		return new StringValue<>(value);
	}

	@Override
	public String typeName() {
		return "string";
	}
	
}
