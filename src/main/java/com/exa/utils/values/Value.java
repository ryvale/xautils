package com.exa.utils.values;

import java.io.Serializable;

import com.exa.utils.ManagedException;

public interface Value<T> extends Serializable {

	T getValue();

	void setValue(T value);

	StringValue asStringValue();

	ObjectValue asObjectValue();

	ArrayValue asArrayValue();

	BooleanValue asBooleanValue();

	DecimalValue asDecimalValue();
	
	IntegerValue asIntegerValue();
	
	CalculableValue asCalculableValue();
	
	Integer asInteger() throws ManagedException;

	ObjectValue asRequiredObjectValue() throws ManagedException;
	
	String asRequiredString() throws ManagedException;
	
	Integer asRequiredInteger() throws ManagedException;

	String asString() throws ManagedException;

}