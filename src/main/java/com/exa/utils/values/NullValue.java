package com.exa.utils.values;

import com.exa.utils.ManagedException;

public class NullValue<_C> implements Value<Object, _C> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getValue() {
		return null;
	}

	@Override
	public String typeName() {
		return "null";
	}

	@Override
	public void setValue(Object value) {
		
	}

	@Override
	public StringValue<_C> asStringValue() {
		return null;
	}

	@Override
	public ObjectValue<_C> asObjectValue() {
		return null;
	}

	@Override
	public ArrayValue<_C> asArrayValue() {
		return null;
	}

	@Override
	public BooleanValue<_C> asBooleanValue() {
		return null;
	}

	@Override
	public DecimalValue<_C> asDecimalValue() {
		return null;
	}

	@Override
	public IntegerValue<_C> asIntegerValue() {
		return null;
	}

	@Override
	public CalculableValue<Object, _C> asCalculableValue() {
		return null;
	}

	@Override
	public ObjectValue<_C> asRequiredObjectValue() throws ManagedException {
		throw new ManagedException("This is null value");
	}

	@Override
	public String asRequiredString() throws ManagedException {
		throw new ManagedException("This is null value");
	}

	@Override
	public Integer asRequiredInteger() throws ManagedException {
		throw new ManagedException("This is null value");
	}

	@Override
	public Boolean asRequiredBoolean() throws ManagedException {
		throw new ManagedException("This is null value");
	}

	@Override
	public Double asRequiredDouble() throws ManagedException {
		throw new ManagedException("This is null value");
	}

	@Override
	public String asString() throws ManagedException {
		return null;
	}

	@Override
	public Integer asInteger() throws ManagedException {
		return null;
	}

	@Override
	public Boolean asBoolean() throws ManagedException {
		return null;
	}

	@Override
	public Double asDouble() throws ManagedException {
		return null;
	}

	@Override
	public NullValue<_C> clone() {
		return this;
	}

	@Override
	public ArrayValue<_C> asRequiredArrayValue() throws ManagedException {
		return null;
	}

}
