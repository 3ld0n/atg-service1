package atg.src;

import java.util.Arrays;

public class Message {

	public String[] getWords() {
		return words;
	}
	public int getLongest() {
		return longest;
	}
	public void setLongest(int l) {
		longest = l;
	}
	public int getShortest() {
		return shortest;
	}
	public void setShortest(int s) {
		shortest = s;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String f) {
		first = f;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String l) {
		last = l;
	}
	public String[] getUnavailable() {
		return unavailable;
	}
	private String[] words;
	private int longest = -1;
	private int shortest = -1;
	private String first;
	private String last;
	private String[] unavailable;
	private void addUnavailable(String service) {
		if(unavailable == null) {
			unavailable = new String[]{service};
			return;
		}
		String[] newun = Arrays.copyOf(unavailable, unavailable.length + 1);
		newun[newun.length-1] = service;
		unavailable = newun;
	}
	public Message(Message1 m1, Message2 m2, Message3 m3) {
		if(m1 != null) {
			words = m1.getWords();
		} else {
			addUnavailable("service1");
		}
		if(m2 != null) {
			shortest = m2.getShortest();
			longest = m2.getLongest();
		} else {
			addUnavailable("service2");
		}
		if(m3 != null) {
			first = m3.getFirst();
			last = m3.getLast();
		} else {
			addUnavailable("service3");
		}
	}
}
