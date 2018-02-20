package com.exa.utils.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils extends IOUtils {

	public FileUtils(String base) {
		super(base);
	}

	@Override
	protected InputStream prepareDownload(String ref) throws IOException {
		return new FileInputStream(ref);
	}

	@Override
	protected boolean endDownload() throws IOException {
		return true;
	}

}
