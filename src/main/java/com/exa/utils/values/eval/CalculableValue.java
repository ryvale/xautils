package com.exa.utils.values.eval;

import java.util.HashMap;
import java.util.Map;

import com.exa.utils.ManagedException;
import com.exa.utils.values.ArrayValue;
import com.exa.utils.values.BooleanValue;
import com.exa.utils.values.CalculEngine;
import com.exa.utils.values.DecimalValue;
import com.exa.utils.values.IntegerValue;
import com.exa.utils.values.ObjectValue;
import com.exa.utils.values.StringValue;
import com.exa.utils.values.Value;

public class CalculableValue<T> implements Value<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Map<String, CalculEngine> calculEngines = new HashMap<>();
	
	public static void addCalculEngine(String type, CalculEngine calculEngine) {
		calculEngines.put(type, calculEngine);
	}
	
	public static void removeCalculEngine(String type) {
		calculEngines.remove(type);
	}
	
	public static CalculEngine getCalculEngine(String type) {
		return calculEngines.get(type);
	}
	
	private String expression;
	
	private String expType;

	public CalculableValue(String expression, String type) {
		super();
		this.expression = expression;
		this.expType = type;
	}
	
	@Override
	public CalculableValue<?> asCalculableValue() {	return this; }

	public String getExpression() {
		return expression;
	}

	public String getExpType() {
		return expType;
	}

	@Override
	public T getValue() {
		CalculEngine engine = getCalculEngine(expType);
		return engine.calculate(this).getValue();
	}

	@Override
	public void setValue(T value) {
		
	}

	@Override
	public StringValue asStringValue() { 
		return null; 
	}

	@Override
	public ObjectValue asObjectValue() { return null; }

	@Override
	public ArrayValue asArrayValue() {	return null; }

	@Override
	public BooleanValue asBooleanValue() { return null;	}

	@Override
	public DecimalValue asDecimalValue() {	return null; }

	@Override
	public ObjectValue asRequiredObjectValue() throws ManagedException {
		return null;
	}

	@Override
	public IntegerValue asIntegerValue() {	return null;}

	@Override
	public String getValueAsString() throws ManagedException {
		return null;
	}
	
	
}
