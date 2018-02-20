package com.exa.utils.io;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;

public class FTPUtils extends IOUtils {
	
	private FTPClient ftpClient;

	public FTPUtils(FTPClient ftpClient, String base) {
		super(base);
		this.ftpClient = ftpClient;
	}
	
	/*public boolean downloadFile(String from, String to, int bufferSize) throws IOException {
		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(to));
		InputStream inputStream = ftpClient.retrieveFileStream(from);
		
		byte[] bytesArray = new byte[bufferSize];
		int bytesRead = -1;
        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
            outputStream.write(bytesArray, 0, bytesRead);
        }
        
        boolean success = ftpClient.completePendingCommand();
        
        outputStream.close();
        inputStream.close();
        
        return success;
	}*/
	
	


	public FTPClient getFtpClient() { return ftpClient; }


	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	@Override
	protected InputStream prepareDownload(String ref) throws IOException {
		return ftpClient.retrieveFileStream(ref);
	}

	@Override
	protected boolean endDownload() throws IOException {
		
		return ftpClient.completePendingCommand();
	}
	
	
	
}
