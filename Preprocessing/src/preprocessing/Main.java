package preprocessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader("input.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		POSTag tag = new POSTag();
		String cSentence;
		while ((cSentence = input.readLine()) != null) {
			if (cSentence.contains("_")) {
				System.out.println("Error: Sentence contains underscore character. Cannot continue.");
				continue;
			}
			String tagged = tag.Tag(cSentence);
			List<String> sentence = new ArrayList<String>(Arrays.asList(cSentence.split(" ")));
			
		
		}
		
		
		
		MultiwordJoin mj = new MultiwordJoin();
		List<String> sentence = new ArrayList<String>(Arrays.asList("Hello", "Suresh", "Sarda", "How", "Are"));
		List<String> postags = new ArrayList<String>(Arrays.asList("AA", "NN", "JJ", "NN", "NN"));
		System.out.println(mj.JoinMultiwords(sentence, postags));
	}
	
		
		
		

}
