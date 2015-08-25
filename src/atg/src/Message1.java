package atg.src;

public class Message1 {

	public String[] getWords() {
		return words;
	}
	private String[] words;
	public Message1(String text) {
		words = text.split("\\s+");
	}
}
