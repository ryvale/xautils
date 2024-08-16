package com.exa.utils.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

public abstract class IOUtils {
	
	private static final int BF_DEFAULT_SIZE = 4096;
	
	public static class FileProperties {
		private String nameWithouExt;
		private String ext;
		
		private String parent;
		
		private String name;
		
		public FileProperties(String nameWithouExt, String ext, String parent, String name) {
			super();
			this.nameWithouExt = nameWithouExt;
			this.ext = ext;
			this.parent = parent;
			this.name = name;
		}

		public String getNameWithouExt() {
			return nameWithouExt;
		}

		public void setNameWithouExt(String nameWithouExt) {
			this.nameWithouExt = nameWithouExt;
		}

		public String getExt() {
			return ext;
		}

		public void setExt(String ext) {
			this.ext = ext;
		}

		public String getParent() {
			return parent;
		}

		public void setParent(String parent) {
			this.parent = parent;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
	private String base;
	
	public IOUtils(String base) {
		super();
		this.base = base;
	}

	public boolean downloadFile(String from, String to, int bufferSize) throws IOException {
		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(to));
		InputStream inputStream = prepareDownload(base+from); //ftpClient.retrieveFileStream(from);
		
		byte[] bytesArray = new byte[bufferSize];
		int bytesRead = -1;
        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
            outputStream.write(bytesArray, 0, bytesRead);
        }
        
        boolean success = endDownload(); //ftpClient.completePendingCommand();
        
        outputStream.close();
        inputStream.close();
        
        return success;
	}
	
	public boolean downloadFile(String from, String to) throws IOException {
		return downloadFile(from, to, BF_DEFAULT_SIZE);
	}
	
	protected abstract InputStream prepareDownload(String ref) throws IOException;
	
	protected abstract boolean endDownload() throws IOException;
	
	public static String normalizedDirectoryPath(String path) {
		return normalizedDirectoryPath(path, null);
	}
	
	public static String normalizedDirectoryPath(String path, String workingDir) {
		
		if(path == null) return null;
		
		path = path.trim();
		
		if(workingDir != null) {
			workingDir = workingDir.trim();
			
			if(path.startsWith(".")) {
				path = ((workingDir.endsWith("/") || workingDir.endsWith("\\")) ? workingDir.substring(0, workingDir.length()-1) : workingDir) + path.substring(1);
			}
				
				
		}
		
		
		
		if(path.endsWith("/")) return path;
		
		if(path.endsWith("\\")) return path.replace('\\', '/');
		
		if(path.contains("/")) return path + "/";
		
		if(path.contains("\\")) {
			return path.replace('\\', '/') + "/";
		}
		
		return path + "/";
	}
	
	public static String normalizedPath(String path) {
		return normalizedPath(path, null);
	}
	
	public static String normalizedPath(String path, String workingDir) {
		
		if(workingDir != null) {
			workingDir = workingDir.trim();
			
			if(path.startsWith(".")) {
				path = ((workingDir.endsWith("/") || workingDir.endsWith("\\")) ? workingDir.substring(0, workingDir.length()-1) : workingDir) + path.substring(1);
			}
		}
		
		if(path.contains("\\")) return path.replace('\\', '/');

		
		return path;
	}
	
	public static String getFileNameWithOutExt(String path) {
		path = normalizedPath(path);
		
		String[] parts = path.split("/");
		
		String[] partParts = parts[parts.length - 1].split(Pattern.quote("."));
		
		return partParts[0];
		
	}
	
	public static FileProperties getFileProperties(String path) {
		path = normalizedPath(path);
		
		String[] parts = path.split("/");
		
		String parent = null;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<parts.length-1; i++) {
			sb.append(parts[i]).append("/");
		}
		if(sb.length()>0) parent = sb.toString();
		
		String[] partParts = parts[parts.length - 1].split(Pattern.quote("."));
		
		if(partParts.length == 1) return new FileProperties(parts[parts.length - 1], null, parent, parts[parts.length - 1]);
		
		
		String nameWithOutExt = null;
		sb.setLength(0);
		for(int i=0; i<partParts.length-1; i++) {
			sb.append(".").append(partParts[i]);
		}
		if(sb.length()>0) nameWithOutExt = sb.substring(1);
	
		
		return new FileProperties(nameWithOutExt, partParts[partParts.length-1], parent, nameWithOutExt + "." + partParts[partParts.length-1]);
		
	}

}
