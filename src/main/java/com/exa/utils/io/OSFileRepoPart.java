package com.exa.utils.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OSFileRepoPart extends RepoPart {
	private String base;

	public OSFileRepoPart(String base) {
		super();
		this.base = IOUtils.normalizedDirectoryPath(base) ;
	}



	@Override
	public InputStream getInputStream(String ref) throws IOException {
		String name = getName(ref);
		
		return new FileInputStream(name);
	}



	@Override
	public String getName(String ref) {
		return base + (ref.startsWith("/") || ref.startsWith("\\") ? ref.substring(1) : ref);
	}

}
