package com.exa.utils.values;

public class CalculableValue<_C> extends MemoryValue<_C, _C> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static interface TokenManager {
		
	}
	
	private String expType;
	
	public CalculableValue(_C value, String expType) {
		super(value);
		
	}

	@Override
	public CalculableValue<_C> asCalculableValue() {
		return this;
	}
	
	public String expType() { return expType; }
	
	
	

}
