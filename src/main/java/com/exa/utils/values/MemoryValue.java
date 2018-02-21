package com.exa.utils.values;

import com.exa.utils.ManagedException;
import com.exa.utils.values.eval.CalculableValue;

public abstract class MemoryValue<T> implements Value<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	protected T value;
	
	protected MemoryValue() {}
	
	public MemoryValue(T value) {
		super();
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#getValue()
	 */
	@Override
	public T getValue() { return value; }

	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#setValue(T)
	 */
	@Override
	public void setValue(T value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asStringValue()
	 */
	@Override
	public StringValue asStringValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asObjectValue()
	 */
	@Override
	public ObjectValue asObjectValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asArrayValue()
	 */
	@Override
	public ArrayValue asArrayValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asBooleanValue()
	 */
	@Override
	public BooleanValue asBooleanValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asDecimalValue()
	 */
	@Override
	public DecimalValue asDecimalValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asCalculableValue()
	 */
	@Override
	public CalculableValue<?> asCalculableValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asRequiredObjectValue()
	 */
	@Override
	public ObjectValue asRequiredObjectValue() throws ManagedException { 
		ObjectValue res = asObjectValue();
		if(res == null)	throw new ManagedException("This value is not an object"); 
		return res;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asIntegerValue()
	 */
	@Override
	public IntegerValue asIntegerValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#getPathAttributAsInetegrEx(java.lang.String)
	 */
/*	@Override
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
*/
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#getValueAsString()
	 */
	@Override
	public String getValueAsString() throws ManagedException {
		StringValue sv = asStringValue();
		if(sv == null) throw new ManagedException(String.format("This value is not a strig value."));
		
		return sv.getValue();
		
	}
	
	/*public String getValueAsString(String pathAttribut) {
		
		try {
			return getValueAsStringEx();
		} catch (ManagedException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}*/
}
