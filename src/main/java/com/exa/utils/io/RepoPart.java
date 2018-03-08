package com.exa.utils.io;

import java.io.IOException;
import java.io.InputStream;

public abstract class RepoPart {
	
	public abstract InputStream getInputStream(String ref) throws IOException;
	
	public abstract String getName(String ref);
}
