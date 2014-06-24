package preprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		/*String test = "This is a simple string.";
		POSTag tag = new POSTag();
		System.out.println(tag.Tag(test));*/
		MultiwordJoin mj = new MultiwordJoin();
		List<String> sentence = new ArrayList(Arrays.asList("Hello", "Suresh", "Sarda", "How", "Are"));
		List<String> postags = new ArrayList(Arrays.asList("AA", "NN", "JJ", "NN", "NN"));
		mj.JoinMultiwords(sentence, postags);
		}
		
		
		

}
