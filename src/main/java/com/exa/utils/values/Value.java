package com.exa.utils.values;

import java.io.Serializable;

import com.exa.utils.ManagedException;

public abstract class Value<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected T value;
	
	protected Value() {}
	
	public Value(T value) {
		super();
		this.value = value;
	}

	public T getValue() { return value; }

	public void setValue(T value) {
		this.value = value;
	}

	public StringValue asStringValue() { return null; }
	
	public ObjectValue asObjectValue() { return null; }
	
	public ObjectValue asRequiredObjectValue() throws ManagedException { 
		ObjectValue res = asObjectValue();
		if(res == null)	throw new ManagedException("This value is not an object"); 
		return res;
	}
	
	public ArrayValue asArrayValue() { return null; }
	
	public IntegerValue asIntegerValue() { return null; }
	
	public Integer getPathAttributAsInetegrEx(String pathAttribut) throws ManagedException {
		
		String parts[] = pathAttribut.split(".");
		
		ObjectValue rpo = asObjectValue();
		
		Value<?> rpv = rpo.getAttribut(parts[0]);
		if(rpv == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
		
		for(int i=1;i<parts.length-1;i++) {
			rpo = rpv.asObjectValue();
			if(rpo == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
			
			rpv = rpo.getAttribut(parts[i]);
		}
		
		IntegerValue rpi = rpv.asIntegerValue();
		if(rpi == null) throw new ManagedException(String.format("The property %s is not an integer.", parts[parts.length - 1]));
		
		return rpi.getValue();
		
	}
	
	public String getValueAsStringEx() throws ManagedException {
		StringValue sv = asStringValue();
		if(sv == null) throw new ManagedException(String.format("This value is not a strig value."));
		
		return sv.getValue();
		
	}
	
	public String getValueAsString(String pathAttribut) {
		
		try {
			return getValueAsStringEx();
		} catch (ManagedException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
