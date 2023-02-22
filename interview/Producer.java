package interview;

public class Producer {
String id;


public String getId() {
	return id;
}


public void setId(String id) {
	this.id = id;
}


public Producer(String id) {
	this.id = id;
}


public void send(String content,String topicName) {
	// Does topic exist or not ?
	Message message = new Message(content);
	Topic topic = KafkaDriver.getTopic(topicName);
	topic.getMessages().add(message);
	System.out.println("count is : ");
}
}
