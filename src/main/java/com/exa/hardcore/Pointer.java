package com.exa.hardcore;

public class Pointer<T> {
	private T deref;
	
	public T deref() { return deref; }
	public void deref(T deref) { this.deref = deref; }
	
	
}
