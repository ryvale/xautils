package com.exa.utils.values;

import java.io.Serializable;

import com.exa.utils.ManagedException;

public interface Value<T, _C> extends Serializable {

	T getValue();

	void setValue(T value);

	StringValue<_C> asStringValue();

	ObjectValue<_C> asObjectValue();

	ArrayValue<_C> asArrayValue();

	BooleanValue<_C> asBooleanValue();

	DecimalValue<_C> asDecimalValue();
	
	IntegerValue<_C> asIntegerValue();
	
	CalculableValue<_C> asCalculableValue();
	
	Integer asInteger() throws ManagedException;

	ObjectValue<_C> asRequiredObjectValue() throws ManagedException;
	
	String asRequiredString() throws ManagedException;
	
	Integer asRequiredInteger() throws ManagedException;

	String asString() throws ManagedException;

}