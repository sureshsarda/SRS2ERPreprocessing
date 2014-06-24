package preprocessing;

public class Main {

	public static void main(String[] args) {
		/*String test = "This is a simple string.";
		POSTag tag = new POSTag();
		System.out.println(tag.Tag(test));*/
		MultiwordJoin mj = new MultiwordJoin();
		String[] sentence = {"Hello", "Suresh", "Sarda", "How", "Are"};
		String[] postags = {"AA", "NN", "JJ", "NN", "NN"};
		mj.JoinMultiwords(sentence, postags);
		}
		
		
		

}
