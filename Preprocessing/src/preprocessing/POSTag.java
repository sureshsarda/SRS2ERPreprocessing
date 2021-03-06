package preprocessing;

import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.Tree;


/**
 * <h1> Part of Speech Tagger </h1>
 * This class provides functionalities to tag part of speech of english sentences
 * @author Suresh Sarda
 * @version 1.0
 * @since 2014-06-24
 */
public class POSTag {
	
	LexicalizedParser lp = null;
	/**
	 * This method initializes all models.
	 * @param None
	 */
	public POSTag() {
		lp = LexicalizedParser.loadModel("tagger/englishPCFG.ser.gz");
	}
	public List<String> Tag(String sentence) {
		String[] sent = sentence.split(" ");
	    List<CoreLabel> rawWords = Sentence.toCoreLabelList(sent);
		Tree parse = lp.apply(rawWords);
		List<CoreLabel> tagged = parse.taggedLabeledYield();
		List<String> tags = new ArrayList<String>();
		for (CoreLabel token : tagged) {
			tags.add(token.toString().split("-")[0]);
		}
	    return tags;
	}
}
