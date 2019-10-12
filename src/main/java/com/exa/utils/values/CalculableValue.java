package com.exa.utils.values;

import com.exa.utils.ManagedException;

public abstract class CalculableValue<T, _C> implements Value<T, _C> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public abstract CalculableValue<T, _C> clone();
	
	public abstract void setContext(String context);
	
	public abstract String getEvalTime();
	
	@Override
	public ArrayValue<_C> asRequiredArrayValue() throws ManagedException { 
		ArrayValue<_C> res = asArrayValue();
		if(res == null)	throw new ManagedException("This value is not an object");
		
		return res;
	}

}
