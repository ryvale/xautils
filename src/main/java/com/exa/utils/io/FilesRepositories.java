package com.exa.utils.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FilesRepositories {
	private Map<String, RepoPart> repoParts = new HashMap<>();
	
	public void addRepoPart(String name, RepoPart part) {
		repoParts.put(name, part);
	}
	
	public InputStream getInputStream(String uri) throws IOException {
		String parts[]  = uri.split("[:]");
		
		RepoPart rp = repoParts.get(parts[0]);
		
		return rp.getInputStream(uri.substring(parts[0].length()));
	}
	
	
	public String getName(String uri) {
		String parts[]  = uri.split("[:]");
		
		RepoPart rp = repoParts.get(parts[0]);
		
		return rp.getName(uri.substring(parts[0].length()+1));
	}
}
