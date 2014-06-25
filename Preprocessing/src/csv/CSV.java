package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSV {
	
	public static final int IMPORT = 0;
	public static final int EXPORT = 1;
	
	BufferedReader reader = null;
	BufferedWriter writer = null;
	
	String enclose = ""; //enclose keywords in this string
	String separator = ","; //separator between 2 keywords
	public CSV(String filename, int process) {
		if (process == EXPORT) {
			try {
				writer = new BufferedWriter(new FileWriter(filename));
			} catch (IOException e) {
				System.err.println("Fatal: Failed to create file at specified location. Check if you have permission.");
			}
		}
		else if (process == IMPORT) {
			try {
				reader = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException e) {
				System.err.println("Fatal: Failed to read file from the location provided.");
			}
		}
	}
	public void WriteLine(String sentence) throws IOException {
		if (writer == null) {
			System.err.println("Operation failed. File opened in reading mode.");
		}
		else {
			String[] words = sentence.split(" ");
			WriteLine(Arrays.asList(words));
		}
	}
	public void WriteLine(List<String> tokens) throws IOException {
		if (writer == null) {
			System.err.println("Operation failed. File opened in reading mode.");
		}
		else {
			int length = tokens.size();
			
			for (int i = 0; i < length; i++) {
				String temp = enclose.concat(tokens.get(i)).concat(enclose);
				if (i < length - 1)
					temp = temp.concat(separator);
				writer.write(temp);
				
			}
			writer.write(System.lineSeparator());
		}
	
	}
	public String ReadLine() throws IOException {
		if (reader == null) {
			System.err.println("Failed to read from file.");
			return null;
		}
		else {
			String line = reader.readLine();
			String[] tokens = line.split(separator);
			for (int i = 0; i < tokens.length; i++) {
				tokens[i] = tokens[i].substring(enclose.length(), tokens[i].length() - enclose.length());
			}
			/*Check the following code. Iam not sure if it works. May have to write manual string conversion function*/
			String temp = tokens.toString();
			return temp;
		}
	}
	public void CloseStreams() throws IOException {
		if (reader != null)
			reader.close();
		if (writer != null)
			writer.close();
	}
	public void SetKeywordEncloser(String encloser) {
		this.enclose = encloser;
	}
	public void SetKeywordSeparator(String separator) {
		this.separator = separator;
	}

}
