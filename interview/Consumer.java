package interview;

import java.util.ArrayList;
import java.util.List;

public class Consumer {
	String id;
	String groupId;
	List<String> topicNames;
	
	
	public List<String> getTopicNames() {
		return topicNames;
	}



	public void setTopicNames(List<String> topicNames) {
		this.topicNames = topicNames;
	}



	Consumer(String id,String groupId) {
		this.id = id;
		this.groupId = groupId;
		topicNames = new ArrayList<>();
	}

	

	public void processTopic(String topicName) {
		Topic topic = KafkaDriver.getTopic(topicName);
		Integer offset = 0;
		if (topic.getGroupIdOffSetMap() != null ) {
			offset = topic.getGroupIdOffSetMap().get(groupId);
		}
		System.out.println("Processing the message");
		int index = 0;
		if(offset == null) {
			index = 0;
		}
		else { 
			index = offset;
		}
		System.out.println(topic.getMessages().get(index).getContent());
		topic.getGroupIdOffSetMap().put(groupId,index+1);

	}

	public void processTopic(String topicName,int number) {
		
	}
}
