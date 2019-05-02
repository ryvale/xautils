package com.exa.utils.values;

import java.io.Serializable;

import com.exa.utils.ManagedException;

public interface Value<T, _C> extends Serializable, Cloneable {

	T getValue();

	void setValue(T value);

	StringValue<_C> asStringValue();

	ObjectValue<_C> asObjectValue();

	ArrayValue<_C> asArrayValue();

	BooleanValue<_C> asBooleanValue();

	DecimalValue<_C> asDecimalValue();
	
	IntegerValue<_C> asIntegerValue();
	
	CalculableValue<T, _C> asCalculableValue();
	
	Integer asInteger() throws ManagedException;
	
	Boolean asBoolean() throws ManagedException;

	ObjectValue<_C> asRequiredObjectValue() throws ManagedException;
	
	String asRequiredString() throws ManagedException;
	
	Integer asRequiredInteger() throws ManagedException;
	
	Boolean asRequiredBoolean() throws ManagedException;

	String asString() throws ManagedException;

	Value<T, _C> clone() throws CloneNotSupportedException;
	
	
}