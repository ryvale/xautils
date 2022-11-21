package com.exa.utils.values;

import java.util.List;
import java.util.Map;

import com.exa.utils.ManagedException;

public abstract class MemoryValue<T, _C> implements Value<T, _C> {
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
	public StringValue<_C> asStringValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asObjectValue()
	 */
	@Override
	public ObjectValue<_C> asObjectValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asArrayValue()
	 */
	@Override
	public ArrayValue<_C> asArrayValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asBooleanValue()
	 */
	@Override
	public BooleanValue<_C> asBooleanValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asDecimalValue()
	 */
	@Override
	public DecimalValue<_C> asDecimalValue() { return null; }
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asRequiredObjectValue()
	 */
	@Override
	public ObjectValue<_C> asRequiredObjectValue() throws ManagedException { 
		ObjectValue<_C> res = asObjectValue();
		if(res == null)	throw new ManagedException("This value is not an object");
		
		
		return res;
	}
	
	@Override
	public ArrayValue<_C> asRequiredArrayValue() throws ManagedException { 
		ArrayValue<_C> res = asArrayValue();
		if(res == null)	throw new ManagedException("This value is not an object");
		
		
		return res;
	}
	
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#asIntegerValue()
	 */
	@Override
	public IntegerValue<_C> asIntegerValue() { return null; }
	
	
	/* (non-Javadoc)
	 * @see com.exa.utils.values.AbstractValue#getValueAsString()
	 */
	@Override
	public String asString() throws ManagedException {
		StringValue<_C> sv = asStringValue();
		if(sv == null) throw new ManagedException(String.format("This value is not a string value."));
		
		return sv.getValue();
	}

	@Override
	public Integer asInteger() throws ManagedException {
		IntegerValue<_C> v = asIntegerValue();
		if(v == null) throw new ManagedException(String.format("This value is not a integer value."));
		
		return v.getValue();
	}
	
	@Override
	public Boolean asBoolean() throws ManagedException {
		BooleanValue<_C> v = asBooleanValue();
		if(v == null) throw new ManagedException(String.format("This value is not a integer value."));
		
		return v.getValue();
	}
	
	@Override
	public Double asDouble() throws ManagedException {
		DecimalValue<_C> v = asDecimalValue();
		if(v == null) throw new ManagedException(String.format("This value is not a integer value."));
		
		return v.getValue();
	}

	@Override
	public List<Value<?, _C>> asArray() throws ManagedException {
		ArrayValue<_C> v = asArrayValue();
		if(v == null) throw new ManagedException(String.format("This value is not an array value."));
		
		return v.getValue();
	}
	
	@Override
	public Map<String, Value<?, _C>> asObject() throws ManagedException {
		ObjectValue<_C> v = asObjectValue();
		if(v == null) throw new ManagedException(String.format("This value is not an array value."));
		
		return v.getValue();
	}

	@Override
	public String asRequiredString() throws ManagedException {
		String res = asString();
		if(res == null) throw new ManagedException("This string value have not to be null.");
		
		return res;
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
	public Boolean asRequiredBoolean() throws ManagedException {
		Boolean res = asBoolean();
		if(res == null) throw new ManagedException("This boolean value have not to be null."); 
		
		return res;
	}
	
	@Override
	public Double asRequiredDouble() throws ManagedException {
		Double res = asDouble();
		if(res == null) throw new ManagedException("This double value have not to be null."); 
		
		return res;
	}

	@Override
	public CalculableValue<T, _C> asCalculableValue() {
		return null;
	}

	@Override
	public abstract MemoryValue<T, _C> clone() /*throws CloneNotSupportedException*/;

	@Override
	public String toString() {
		if(value == null) return null;
		return value.toString();
	}
	
}
