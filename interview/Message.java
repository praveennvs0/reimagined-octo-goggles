package interview;

public class Message {
	static int count = 0;
	public Message(String content) {
		this.id = count++;
		this.content = content;
	}
	int id; 
	String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
