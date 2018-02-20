package com.exa.utils.values;

import java.util.ArrayList;
import java.util.List;

import com.exa.utils.ManagedException;

public class ArrayValue extends Value<List<Value<?>>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArrayValue() {
		super(new ArrayList<>());
	}

	@Override
	public ArrayValue asArrayValue() {
		return this;
	}
	
	public String getString(int i) throws ManagedException {
		try {
			Value<?> vl = value.get(i);
			if(vl == null) return null;
			StringValue svl =  vl.asStringValue();
			if(svl == null) throw new ManagedException(String.format("This array item is not a string value"));
			
			return svl.getValue();
		}
		catch (IndexOutOfBoundsException e) {
			throw new ManagedException(e);
		}
		
	}
	
	public String getString(int i, String defautValue) throws ManagedException {
		String res = getString(i);
		
		if(res == null) return defautValue;
		
		return res;
	}
	
	public ObjectValue getObjectValue(int i) throws ManagedException {
		try {
			Value<?> vl = value.get(i);
			if(vl == null) return null;
			ObjectValue ovl =  vl.asObjectValue();
			if(ovl == null) throw new ManagedException(String.format("This array item is not an object value"));
			
			return ovl;
		}
		catch (IndexOutOfBoundsException e) {
			throw new ManagedException(e);
		}
		
	}
	
	public ObjectValue getObjectValue(int i, ObjectValue defautValue) throws ManagedException {
		ObjectValue res = getObjectValue(i);
		
		if(res == null) return defautValue;
		
		return res;
	}
	
	public void add(Value<?> item) {
		value.add(item);
	}

	public void add(String item) {
		value.add(new StringValue(item));
	}
	
	public ObjectValue addObjectValue() {
		ObjectValue res = new ObjectValue();
		value.add(res);
		return res;
	}
	
	public ArrayValue addArrayValue() {
		ArrayValue res = new ArrayValue();
		value.add(res);
		return res;
	}
 
}
