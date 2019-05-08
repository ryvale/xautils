package com.exa.utils.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class FilesRepositories {
	public final static String REP_DEFAULT = "default";
	
	private Map<String, RepoPart> repoParts = new HashMap<>();
	
	private String defaultRep;
	
	public FilesRepositories(String defaultRep) {
		super();
		this.defaultRep = defaultRep;
	}
	
	public FilesRepositories() { this(REP_DEFAULT); }

	public void addRepoPart(String name, RepoPart part) {
		repoParts.put(name, part);
	}
	
	public InputStream getInputStream(String uri) throws IOException {
		String parts[]  = uri.split("[:]");
		
		String repName; String resName;
		if(parts.length == 1) {
			repName = defaultRep;
			resName = uri;
		}
		else {
			repName = parts[0];
			resName = uri.substring(parts[0].length()+1);
		}
		
		RepoPart rp = repoParts.get(repName);
		
		return rp.getInputStream(resName);
	}
	
	
	public String getName(String uri) {
		String parts[]  = uri.split("[:]");
		
		String repName; String resName;
		if(parts.length == 1) {
			repName = defaultRep;
			resName = uri;
		}
		else {
			repName = parts[0];
			resName = uri.substring(parts[0].length()+1);
		}
		
		RepoPart rp = repoParts.get(repName);
		
		return rp.getName(resName);
	}
}
