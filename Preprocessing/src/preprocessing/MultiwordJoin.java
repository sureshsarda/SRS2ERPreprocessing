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
	int[] sequenceHash = null;
	public MultiwordJoin() {
		notedSequence = new ArrayList<List<String>>();
		
		
		/*
		 * IMPORTANT: Add to list according to priority. The first sequence will be considered and joined and
		 * subsequent sequences will be skipped.
		 */
		notedSequence.add(Arrays.asList("NN", "NN"));
		notedSequence.add(Arrays.asList("JJ", "NN"));
		
		/*Calculate hash of each sequence to use in RobinKarp*/
		sequenceHash = new int[notedSequence.size()];
		for (int i = 0; i < notedSequence.size(); i++) {
			sequenceHash[i] = notedSequence.get(i).hashCode();
		}
	}
	/**
	 * This method joins entities/keywords spanning more than one word in the sentence.
	 * It uses part of speech of the sentence and combines all the part of speech sequence given in
	 * notedSequence into one word
	 * 
	 * @param sentence The sentence which is to be joined
	 * @param postags Part of Speech tags of the sentence to help joining process
	 * @return String Multi words joined by underscore character('_')
	 * @exception ArrayIndexOutOfBoundsException When the size of sentence is not equal to size of postags, this method throws
	 * an ArrayIndexOutOfBoundException
	 * @see ArrayIndexOutOfBoundsException
	 */
	public String JoinMultiwords(List<String> sentence, List<String> postags) {
		List<String> processed = new ArrayList<String>();
		try {
			/*
			 * The following piece of code checks every sequence on the sentence.
			 * Loops through every sequence and for that particular sequence, checks if that sequence is found in sentence
			 * For optimization purpose, instead of checking strings, first hash value is checked and then if matched, strings are checked
			 * 		If a match is found, a new word(combined) of all the words from the sentence is created.
			 * 		add the created word into processed list which contains the new sentence
			 * In either case of mismatch, words without modification is added to processed array
			 * 
			 * The above loop over sentence leaves last (n - 1) words where n is the size of testSequence, and therefore another loop
			 * is used to append all those unprocessed words.
			 */
			for (int j = 0; j < notedSequence.size(); j++) {
				int i;
				for (i = 0; i < postags.size() - notedSequence.get(j).size() + 1; i++) {
					/*Check Hash values*/
					if (postags.subList(i, i + notedSequence.get(j).size()).hashCode() == sequenceHash[j]) {
						/*Hash values are same, now confirm by checking actual strings*/
						if (postags.subList(i, i + notedSequence.get(j).size()).equals(notedSequence.get(j))) {
							/*Match Found*/
							
							/*Create a combined word of matched sequence*/
							String word = new String();
							for (int k = 0; k < notedSequence.get(j).size(); k++) {
								if (k == 0)
									word = word.concat(sentence.get(i + k));
								else
									word = word.concat("_").concat(sentence.get(i + k));
							}
							processed.add(word);
							/*Increment comaprasion index to next pos word after this sequenc*/
							i = i + notedSequence.get(j).size() - 1;
						}
						else {
							processed.add(sentence.get(i));
						}
					}
					else {
						processed.add(sentence.get(i));
					}
				
				}
				/*Append unprocessed words to list*/
				for (; i < postags.size(); i++) {
					processed.add(sentence.get(i));
				}
				sentence = processed;
				processed.clear();
			}
		}
		catch (ArrayIndexOutOfBoundsException aioobe) {
			throw aioobe;
		}
		return processed.toString();
	}

	
}
