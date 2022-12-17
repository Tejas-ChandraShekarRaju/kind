package com.kind.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Utils {
	
	public void writeFileToDisk(String filePath, String fileName, MultipartFile document) throws FileNotFoundException, IOException {
		File file = new File(filePath+fileName);
		try (OutputStream os = new FileOutputStream(file)) {
		    os.write(document.getBytes());
		}
	}

}
