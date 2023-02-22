package interview;

public class MessageTest {

	public static void main(String[] args) {
		
		KafkaDriver.addTopic("TopicA");
		
		Producer producer1 = new Producer("producer1");
		producer1.send("Hello World","TopicA");
		
		Consumer consumer1 = new Consumer("consumer1","groupId1");
		KafkaDriver.subscribe(consumer1,"TopicA");
		
		consumer1.processTopic("TopicA");
		
		producer1.send("Hello World2", "TopicA");
		
		
		Consumer consumer2 = new Consumer("consumer2","groupId1");
		KafkaDriver.subscribe(consumer2,"TopicA");
		
		consumer2.processTopic("TopicA");
		
	}

}
