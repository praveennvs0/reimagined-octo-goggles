package interview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KafkaDriver {
	
	private static Map<String,Topic> topicNameMap = new HashMap<>();

	public static void addTopic(String topicName) {
		if(!topicNameMap.containsKey(topicName)) {
			Topic topic = new Topic(topicName);
			topicNameMap.put(topicName,topic);
		}
		else {
			System.out.println("Topic already exists");
		}
		
	}
	
	
	public static Topic getTopic(String topicName) {
		return topicNameMap.get(topicName);
	}
	
	public static void subscribe(Consumer consumer,String topicName) {
		Topic topic = KafkaDriver.getTopic(topicName);
		// if topic does not exist ?
		List<Consumer> consumerList = topic.getConsumers() ;
		consumerList.add(consumer);
		// How many can subscribe ?
		topic.setConsumers(consumerList);
		consumer.getTopicNames().add(topicName);
	} 
	
	
	
}
