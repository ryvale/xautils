package com.exa.utils.values;

public abstract class CalculableValue<T, _C> implements Value<T, _C> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public abstract CalculableValue<T, _C> clone() throws CloneNotSupportedException;
	
	//public abstract String getContext();
	
	public abstract String typeName();
	
	public abstract void setContext(String context);
	
	public abstract String getEvalTime();


}
