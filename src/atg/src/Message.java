package atg.src;

public class Message {

	public String[] getWords() {
		return words;
	}
	public int getLongest() {
		return longest;
	}
	public int getShortest() {
		return shortest;
	}
	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
	}
	private String[] words;
	private int longest;
	private int shortest;
	private String first;
	private String last;
	public Message(String text) {
		words = text.split("\\s+");
		longest = 0;
		shortest = text.length();
		for(int x = 0 ; x < words.length ; x++) {
			if(words[x].length() < shortest) shortest = words[x].length();
			if(words[x].length() > longest) longest = words[x].length();
			first = words[0];
			last = words[words.length-1];
		}
	}
}
