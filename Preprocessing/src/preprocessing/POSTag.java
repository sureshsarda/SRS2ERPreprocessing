package preprocessing;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/**
 * <h1> Part of Speech Tagger </h1>
 * This class provides functionalities to tag part of speech of english sentences
 * @author Suresh Sarda
 * @version 1.0
 * @since 2014-06-24
 */
public class POSTag {
	MaxentTagger tagger = null;
	/**
	 * This method initializes all models.
	 * @param None
	 */
	public POSTag() {
		tagger = new MaxentTagger("tagger/english-left3words-distsim.tagger");
	}
	public String Tag(String sentence) {
		return tagger.tagString(sentence);
	}
}
