package preprocessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * <h1> Join Entity/Attributes spanning more than single word <h1>
 * 
 * @author Suresh Sarda
 * @version 1.0
 * @since 2014-06-24
 */
public class MultiwordJoin {
	List<List<String>> notedSequence = null;
	public MultiwordJoin() {
		notedSequence = new ArrayList<List<String>>();
		notedSequence.add(Arrays.asList("NN", "NN"));
		notedSequence.add(Arrays.asList("JJ", "NN"));
	}
	/**
	 * This method joins entities/keywords spanning more than one word in the sentence.
	 * It uses part of speech of the sentence and combines all the part of speech sequence given in
	 * notedSequence into one word
	 * 
	 * @param sentence The sentence which is to be joined
	 * @param postags Part of Speect tags of the sentence to help joining process
	 * @return String Multi words joined by underscore character('_')
	 * @exception ArrayIndexOutOfBoundsException When the size of sentence is not equal to size of postags, this method throws
	 * an ArrayIndexOutOfBoundException
	 * @see ArrayIndexOutOfBoundsException
	 */
	public String JoinMultiwords(String[] sentence, String[] postags) {
		try {
			for (List<String> sequence : notedSequence) {
				System.out.println(Arrays.asList(postags).containsAll(sequence));
				
			}
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {
			
		}
		return null;
	}
	
}
