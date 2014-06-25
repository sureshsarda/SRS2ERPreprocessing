package preprocessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import csv.CSV;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader("input.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		POSTag tag = new POSTag();
		MultiwordJoin mj = new MultiwordJoin();
		
		String cSentence;
		CSV output = new CSV("output.csv", CSV.EXPORT);
		while ((cSentence = input.readLine()) != null) {
			List<String> postags = tag.Tag(cSentence);
			List<String> sentence  = Arrays.asList(cSentence.split(" "));
			

			String joined = mj.JoinMultiwords(sentence, postags);
			System.out.println(joined);
			postags = tag.Tag(joined);
			System.out.println(postags);
			
			System.out.println();
			
			output.WriteLine(joined);
			output.WriteLine(postags);
			
		
		}
		output.CloseStreams();
		
		


	}
	
		
		
		

}
