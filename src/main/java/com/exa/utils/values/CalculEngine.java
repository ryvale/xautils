package com.exa.utils.values;

import com.exa.utils.values.eval.CalculableValue;

public interface CalculEngine {
	public static final String T_STRING = "String";
	public static final String T_INTEGER = "Integer";
	public static final String T_DECIMAL = "Decimal";
	public static final String T_BOOLEAN = "Boolean";
	public static final String T_ARRAY = "Array";
	
	<T>MemoryValue<T> calculate(CalculableValue<T> cv);
	
	String getType(String expression);
	
}
