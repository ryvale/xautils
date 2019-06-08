package com.exa.utils.values;

import java.util.ArrayList;
import java.util.List;

import com.exa.utils.ManagedException;

public class ArrayValue<_C> extends MemoryValue<List<Value<?, _C>>, _C> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArrayValue() {
		super(new ArrayList<>());
	}
	
	

	public ArrayValue(List<Value<?, _C>> value) {
		super(value);
		
	}



	@Override
	public ArrayValue<_C> asArrayValue() {
		return this;
	}
	
	public String getString(int i) throws ManagedException {
		try {
			Value<?, _C> vl = value.get(i);
			if(vl == null) return null;
			StringValue<_C> svl =  vl.asStringValue();
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
	
	public ObjectValue<_C> getObjectValue(int i) throws ManagedException {
		try {
			Value<?, _C> vl = value.get(i);
			if(vl == null) return null;
			ObjectValue<_C> ovl =  vl.asObjectValue();
			if(ovl == null) throw new ManagedException(String.format("This array item is not an object value"));
			
			return ovl;
		}
		catch (IndexOutOfBoundsException e) {
			throw new ManagedException(e);
		}
		
	}
	
	public ObjectValue<_C> getObjectValue(int i, ObjectValue<_C> defautValue) throws ManagedException {
		ObjectValue<_C> res = getObjectValue(i);
		
		if(res == null) return defautValue;
		
		return res;
	}
	
	public void add(Value<?, _C> item) {
		value.add(item);
	}

	public void add(String item) {
		value.add(new StringValue<_C>(item));
	}
	
	public ObjectValue<_C> addObjectValue() {
		ObjectValue<_C> res = new ObjectValue<>();
		value.add(res);
		return res;
	}
	
	public ArrayValue<_C> addArrayValue() {
		ArrayValue<_C> res = new ArrayValue<>();
		value.add(res);
		return res;
	}

	@Override
	public ArrayValue<_C> clone() throws CloneNotSupportedException {
		ArrayValue<_C> res = new ArrayValue<>();
		
		for(Value<?, _C> vl : value) {
			res.add(vl.clone());
		}
		return res;
	}

	public Value<?, _C> get(int i) {
		return value.get(i);
	}

	@Override
	public String typeName() {
		return "array";
	}
 
}
