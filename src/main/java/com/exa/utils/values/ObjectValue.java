package com.exa.utils.values;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.exa.utils.ManagedException;

public class ObjectValue<_C> extends MemoryValue<Map<String, Value<?, _C>>, _C> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectValue() {
		super(new LinkedHashMap<>());
	}
	
	@Override
	public ObjectValue<_C> asObjectValue() {
		return this;
	}
	
	

	public boolean containsAttribut(String name) {
		return value.containsKey(name);
	}
	
	public String getAttributAsString(String name) throws ManagedException {
		Value<?, _C> v = value.get(name);
		if(v == null) return null;
		
		StringValue<_C> ov = v.asStringValue();
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
		Value<?, _C> v = value.get(name);
		if(v == null) throw new ManagedException(String.format("The property %s is required.", name));
		
		StringValue<_C> ov = v.asStringValue();
		if(ov == null) throw new ManagedException(String.format("The property %s is not an string.", name));
		
		return ov.toString();
	}
	
	public ObjectValue<_C> getRequiredAttributAsObjectValue(String name) throws ManagedException {
		ObjectValue<_C> ov = getAttributAsObjectValue(name);
		if(ov == null) throw new ManagedException(String.format("The property %s is required.", name));
		
		return ov;
	}
	
	public ObjectValue<_C> getAttributAsObjectValue(String name) throws ManagedException {
		Value<?, _C> v = value.get(name);
		if(v == null) return null;
		
		ObjectValue<_C> ov = v.asObjectValue();
		if(ov == null) throw new ManagedException(String.format("The property %s is not an object value.", name));
		
		return ov;
	}
	
	public Map<String, Value<?, _C>> getAttributAsMap(String name) throws ManagedException {
		Value<?, _C> v = value.get(name);
		if(v == null) return null;
		
		ObjectValue<_C> ov = v.asObjectValue();
		if(ov == null) throw new ManagedException(String.format("The property %s is not an object value.", name));
		
		return ov.getValue();
	}
		
	public Integer getRequiredAttributAsInteger(String name) throws ManagedException {
		Integer res = getAttributAsInteger(name);
		if(res == null) throw new ManagedException(String.format("The property %s is required.", name));
		
		return res;
	}
	
	public Integer getAttributAsInteger(String name) throws ManagedException {
		Value<?, _C> v = value.get(name);
		if(v == null) return null;
		
		IntegerValue<_C> ov = v.asIntegerValue();
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
	
	public Value<?, _C> getAttribut(String name) {
		return value.get(name);
	}
	
	public Value<?, _C> getRequiredAttribut(String name) throws ManagedException {
		Value<?, _C> res = value.get(name);
		if(res == null) throw new ManagedException(String.format("The property %s is required.", name));
		
		return res;
	}
	
	
	public List<Value<?, _C>> getRequiredAttributAsArray(String name) throws ManagedException {
		List<Value<?, _C>> res = getAttributAsArray(name);
		if(res == null) throw new ManagedException(String.format("The property %s is required.", name));
		
		return res;
	}
	
	public ArrayValue<_C> getAttributAsArrayValue(String name) throws ManagedException {
		Value<?, _C> v = value.get(name);
		if(v == null) return null;
		
		ArrayValue<_C> av = v.asArrayValue();
		if(av == null) throw new ManagedException(String.format("The property %s is not an array value", name));
		
		return av;
	}
	
	public List<Value<?, _C>> getAttributAsArray(String name) throws ManagedException {
		Value<?, _C> v = value.get(name);
		if(v == null) return null;
		
		ArrayValue<_C> av = v.asArrayValue();
		if(av == null) throw new ManagedException(String.format("The property %s is not an array value", name));
		
		return av.getValue();
	}
		
	public String getPathAttributAsString(String pathAttribut) throws ManagedException {
		
		String parts[] = pathAttribut.split("[.]");
		
		Value<?, _C> rpv = getAttribut(parts[0]);
		//if(rpv == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
		
		for(int i=1;i<parts.length;i++) {
			ObjectValue<_C> rpo = rpv.asObjectValue();
			if(rpo == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
			
			rpv = rpo.getAttribut(parts[i]);
		}
		
		if(rpv == null) return null;
		
		StringValue<_C> rps = rpv.asStringValue();
		if(rps == null) throw new ManagedException(String.format("The property %s is not a string.", parts[parts.length - 1]));
		
		return rps.getValue();
	}
	
	public ArrayValue<_C> getPathAttributAsArrayValue(String pathAttribut) throws ManagedException {
		
		String parts[] = pathAttribut.split("[.]");
		
		Value<?, _C> rpv = getAttribut(parts[0]);
		if(rpv == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
		
		for(int i=1;i<parts.length;i++) {
			ObjectValue<_C> rpo = rpv.asObjectValue();
			if(rpo == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
			
			rpv = rpo.getAttribut(parts[i]);
		}
		
		ArrayValue<_C> av = rpv.asArrayValue();
		if(av == null) throw new ManagedException(String.format("The property %s is not a string.", parts[parts.length - 1]));
		
		return av;
	}
	
	public List<Value<?, _C>> getPathAttributAsArray(String pathAttribut) throws ManagedException {
		
		String parts[] = pathAttribut.split("[.]");
		
		Value<?, _C> rpv = getAttribut(parts[0]);
		if(rpv == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
		
		for(int i=1;i<parts.length;i++) {
			ObjectValue<_C> rpo = rpv.asObjectValue();
			if(rpo == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
			
			rpv = rpo.getAttribut(parts[i]);
		}
		
		ArrayValue<_C> av = rpv.asArrayValue();
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
	
	public ObjectValue<_C> getPathAttributAsObjecValue(String pathAttribut) throws ManagedException {
		
		String parts[] = pathAttribut.split("[.]");
		
		Value<?, _C> rpv = getAttribut(parts[0]);
		//if(rpv == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
		
		for(int i=1;i<parts.length;i++) {
			ObjectValue<_C> rpo = rpv.asObjectValue();
			if(rpo == null) throw new ManagedException(String.format("The property path %s canot be reach.", pathAttribut));
			
			rpv = rpo.getAttribut(parts[i]);
		}
		
		
		if(rpv == null) return null;
		
		ObjectValue<_C> ov = rpv.asObjectValue();
		if(ov == null) throw new ManagedException(String.format("The property %s is not an object.", parts[parts.length - 1]));
		
		return ov; //.getAttributAsObjectValue(parts[parts.length - 1]);
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
		value.put(name, new StringValue<_C>(avalue));
	}
	
	public void setAttribut(String name, Value<?, _C> avalue) {
		value.put(name, avalue);
	}
	
	public ObjectValue<_C> addObjectValueAttribut(String name) {
		ObjectValue<_C> res = new ObjectValue<>();
		value.put(name, res);
		
		return res;
	}
	
	public ArrayValue<_C> addArrayValueAttribut(String name) {
		ArrayValue<_C> res = new ArrayValue<>();
		value.put(name, res);
		
		return res;
	}
	
	public Integer getIntOrStringIntAttribut(String name) throws ManagedException {
		IntegerValue<_C> iv = asIntegerValue();
		
		if(iv == null) {
			StringValue<_C> sv = asStringValue();
			if(sv == null) throw new ManagedException(String.format("This is not an integer or could not be convertes."));
			
			String s = sv.getValue();
			if(s == null) return null;
		
			try {
				Integer res = Integer.valueOf(s);
				
				return res;
			}catch(NumberFormatException e) {
				throw new ManagedException(e);
			}
			
		}
		
		return iv.getValue();
	}
	
	public Integer getRequiredIntOrStringIntAttribut(String name) throws ManagedException {
		Integer res = getIntOrStringIntAttribut(name);
		if(res == null) throw new ManagedException(String.format("The property %s should not be null", name));
		
		return res;
		
	}

}
