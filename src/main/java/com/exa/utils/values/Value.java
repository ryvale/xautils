package com.exa.utils.values;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.exa.utils.ManagedException;

public interface Value<T, _C> extends Serializable, Cloneable {

	T getValue();
	
	public abstract String typeName();

	void setValue(T value);

	StringValue<_C> asStringValue();

	ObjectValue<_C> asObjectValue();

	ArrayValue<_C> asArrayValue();

	BooleanValue<_C> asBooleanValue();

	DecimalValue<_C> asDecimalValue();
	
	IntegerValue<_C> asIntegerValue();
	
	CalculableValue<T, _C> asCalculableValue();
	
	ObjectValue<_C> asRequiredObjectValue() throws ManagedException;
	
	ArrayValue<_C> asRequiredArrayValue() throws ManagedException;
	
	String asRequiredString() throws ManagedException;
	
	Integer asRequiredInteger() throws ManagedException;
	
	Boolean asRequiredBoolean() throws ManagedException;
	
	Double asRequiredDouble() throws ManagedException;

	String asString() throws ManagedException;
	
	Integer asInteger() throws ManagedException;
	
	Boolean asBoolean() throws ManagedException;
	
	Double asDouble() throws ManagedException;
	
	List<Value<?, _C>> asArray() throws ManagedException;
	
	Map<String, Value<?, _C>> asObject() throws ManagedException;
	
	Value<T, _C> clone() /*throws CloneNotSupportedException*/;
	
}