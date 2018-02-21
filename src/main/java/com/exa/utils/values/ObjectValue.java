package com.exa.utils.values;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exa.utils.ManagedException;

public class ObjectValue extends MemoryValue<Map<String, Value<?>>> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectValue() {
		super(new HashMap<>());
	}
	
	@Override
	public ObjectValue asObjectValue() {
		return this;
	}
	
	

	public boolean containsAttribut(String name) {
		return value.containsKey(name);
	}
	
	public String getAttributAsString(String name) throws ManagedException {
		Value<?> v = value.get(name);
		if(v == null) return null;
		
		StringValue ov = v.asStringValue();
		if(ov == null) throw new ManagedException(String.format("The property %s is not an string", name));
		
		return ov.toString();
	}
	
	public String getAttributAsString(String name, String defaultValue) throws ManagedException {
		String res  = getAttributAsString(name);
		
		if(res == null) return defaultValue;
		
		return res;
	}
	
	/*public String getAttributAsString(String name) {
		Value<?> v = value.get(name);
		if(v == null) return null;
		
		StringValue ov = v.asStringValue();
		if(ov == null) return null;
		
		return ov.toString();
	}*/
	
	public String getRequiredAttributAsString(String name) throws ManagedException {
		Value<?> v = value.get(name);
		if(v == null) throw new ManagedException(String.format("The property %s is required.", name));
		
		StringValue ov = v.asStringValue();
		if(ov == null) throw new ManagedException(String.format("The property %s is not an string.", name));
		
		return ov.toString();
	}
	
	public ObjectValue getRequiredAttributAsObjectValue(String name) throws ManagedException {
		ObjectValue ov = getAttributAsObjectValue(name);
		if(ov == null) throw new ManagedException(String.format("The property %s is required.", name));
		
		return ov;
	}
	
	public ObjectValue getAttributAsObjectValue(String name) throws ManagedException {
		Value<?> v = value.get(name);
		if(v == null) return null;
		
		ObjectValue ov = v.asObjectValue();
		if(ov == null) throw new ManagedException(String.format("The property %s is not an object value.", name));
		
		return ov;
	}
	
	/*public ObjectValue getAttributAsObjectValue(String name) {
		Value<?> v = value.get(name);
		if(v == null) return null;
		
		ObjectValue ov = v.asObjectValue();
		if(ov == null) return null;
		
		return ov;
	}*/
	
	public Integer getRequiredAttributAsInteger(String name) throws ManagedException {
		Integer res = getAttributAsInteger(name);
		if(res == null) throw new ManagedException(String.format("The property %s is required.", name));
		
		return res;
	}
	
	public Integer getAttributAsInteger(String name) throws ManagedException {
		Value<?> v = value.get(name);
		if(v == null) return null;
		
		IntegerValue ov = v.asIntegerValue();
		if(ov == null) throw new ManagedException(String.format("The property %s is not an integer value.", name));
		
		return ov.getValue();
	}
	
	/*public Integer getAttributAsInteger(String name) {
		Value<?> v = value.get(name);
		if(v == null) return null;
		
		IntegerValue ov = v.asIntegerValue();
		if(ov == null) return null;
		
		return ov.getValue();
	}*/
	
	public Value<?> getAttribut(String name) {
		return value.get(name);
	}
	
	public List<Value<?>> getRequiredAttributAsArray(String name) throws ManagedException {
		List<Value<?>> res = getAttributAsArray(name);
		if(res == null) throw new ManagedException(String.format("The property %s is required.", name));
		
		return res;
	}
	
	public List<Value<?>> getAttributAsArray(String name) throws ManagedException {
		Value<?> v = value.get(name);
		if(v == null) return null;
		
		ArrayValue av = v.asArrayValue();
		if(av == null) throw new ManagedException(String.format("The property %s is not an array value", name));
		
		return av.getValue();
	}
	
	
	/*public ArrayValue getAttributAsArrayValue(String name) throws ManagedException {
		Value<?> v = value.get(name);
		if(v == null) return null;
		
		ArrayValue av = v.asArrayValue();
		if(av == null) throw new ManagedException(String.format("The property %s is not an array value", name));
		
		return av;
	}*/
	
	public String getPathAttributAsString(String pathAttribut) throws ManagedException {
		
		String parts[] = pathAttribut.split("[.]");
		
		Value<?> rpv = getAttribut(parts[0]);
		if(rpv == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
		
		for(int i=1;i<parts.length;i++) {
			ObjectValue rpo = rpv.asObjectValue();
			if(rpo == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
			
			rpv = rpo.getAttribut(parts[i]);
		}
		
		StringValue rps = rpv.asStringValue();
		if(rps == null) throw new ManagedException(String.format("The property %s is not a string.", parts[parts.length - 1]));
		
		return rps.getValue();
	}
	
	public List<Value<?>> getPathAttributAsArray(String pathAttribut) throws ManagedException {
		
		String parts[] = pathAttribut.split("[.]");
		
		Value<?> rpv = getAttribut(parts[0]);
		if(rpv == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
		
		for(int i=1;i<parts.length;i++) {
			ObjectValue rpo = rpv.asObjectValue();
			if(rpo == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
			
			rpv = rpo.getAttribut(parts[i]);
		}
		
		ArrayValue av = rpv.asArrayValue();
		if(av == null) throw new ManagedException(String.format("The property %s is not a string.", parts[parts.length - 1]));
		
		return av.getValue();
	}
	
	/*public String getPathAttributAsString(String pathAttribut) {
		
		try {
			return getPathAttributAsStringEx(pathAttribut);
		} catch (ManagedException e) {
			e.printStackTrace();
		}
		
		return null;
	}*/
	
	public ObjectValue getPathAttributAsObjecValue(String pathAttribut) throws ManagedException {
		
		String parts[] = pathAttribut.split("[.]");
		
		Value<?> rpv = getAttribut(parts[0]);
		if(rpv == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
		
		for(int i=1;i<parts.length;i++) {
			ObjectValue rpo = rpv.asObjectValue();
			if(rpo == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
			
			rpv = rpo.getAttribut(parts[i]);
		}
		
		ObjectValue ov = rpv.asObjectValue();
		if(ov == null) throw new ManagedException(String.format("The property %s is not an object.", parts[parts.length - 1]));
		
		return ov.getAttributAsObjectValue(parts[parts.length - 1]);
	}
	
	/*public ObjectValue getPathAttributAsObjecValue(String pathAttribut) {
		
		try {
			return getPathAttributAsObjecValueEx(pathAttribut);
		} catch (ManagedException e) {
			e.printStackTrace();
		}
		
		return null;
	}*/
	
	public void setAttribut(String name, String avalue) {
		value.put(name, new StringValue(avalue));
	}
	
	public void setAttribut(String name, Value<?> avalue) {
		value.put(name, avalue);
	}
	
	public ObjectValue addObjectValueAttribut(String name) {
		ObjectValue res = new ObjectValue();
		value.put(name, res);
		
		return res;
	}
	
	public ArrayValue addArrayValueAttribut(String name) {
		ArrayValue res = new ArrayValue();
		value.put(name, res);
		
		return res;
	}
	

}
