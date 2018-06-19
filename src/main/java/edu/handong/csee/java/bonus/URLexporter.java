package edu.handong.csee.java.bonus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class URLexporter {
	
	public void exportURL(BufferedReader in, String filePath) throws Exception{
		String inputLine;
        
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filePath + "\\index.html"), "UTF-8"));
        while ((inputLine = in.readLine()) != null)
        	bufferedWriter.write(inputLine + "\n");
        
        in.close();
		bufferedWriter.close();
	}
}
