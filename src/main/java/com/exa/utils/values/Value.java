package com.exa.utils.values;

import java.io.Serializable;

import com.exa.utils.ManagedException;
import com.exa.utils.values.eval.CalculableValue;

public interface Value<T> extends Serializable {

	T getValue();

	void setValue(T value);

	StringValue asStringValue();

	ObjectValue asObjectValue();

	ArrayValue asArrayValue();

	BooleanValue asBooleanValue();

	DecimalValue asDecimalValue();
	
	IntegerValue asIntegerValue();

	CalculableValue<?> asCalculableValue();

	ObjectValue asRequiredObjectValue() throws ManagedException;

//	Integer getPathAttributAsInetegrEx(String pathAttribut) throws ManagedException;

	String getValueAsString() throws ManagedException;

}