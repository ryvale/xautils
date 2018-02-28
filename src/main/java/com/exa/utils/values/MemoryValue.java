package com.exa.utils.values;

import com.exa.utils.ManagedException;

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
	 * @see com.exa.utils.values.AbstractValue#getValueAsString()
	 */
	@Override
	public String asString() throws ManagedException {
		StringValue sv = asStringValue();
		if(sv == null) throw new ManagedException(String.format("This value is not a string value."));
		
		return sv.getValue();
		
	}

	@Override
	public Integer asInteger() throws ManagedException {
		IntegerValue v = asIntegerValue();
		if(v == null) throw new ManagedException(String.format("This value is not a integer value."));
		
		return v.getValue();
	}

	@Override
	public Integer asRequiredInteger() throws ManagedException {
		/*IntegerValue v = asIntegerValue();
		if(v == null) throw new ManagedException("This value is not an object"); */
		
		Integer res = asInteger();
		if(res == null) throw new ManagedException("This integer value have not to be null."); 
		
		return res;
	}

	@Override
	public CalculableValue asCalculableValue() {
		return null;
	}

	@Override
	public String asRequiredString() throws ManagedException {
		String res = asString();
		if(res == null) throw new ManagedException("This string value have not to be null.");
		
		return res;
	}
	
	
	
	
}
