package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic {
	

	String topicName;
	List<Message> messages;
	List<Consumer> consumers;
	Map<String,Integer> groupIdOffSetMap ;

	Topic(String topicName) {
		this.topicName = topicName;
		messages = new ArrayList<Message>() ;
		consumers = new ArrayList<Consumer>();
		groupIdOffSetMap  = new HashMap<>();

	}
	
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Consumer> getConsumers() {
		return consumers;
	}
	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}
	public Map<String, Integer> getGroupIdOffSetMap() {
		return groupIdOffSetMap;
	}
	public void setGroupIdOffSetMap(Map<String, Integer> groupIdOffSetMap) {
		this.groupIdOffSetMap = groupIdOffSetMap;
	}

}
