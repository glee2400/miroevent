package ca.on.miro.event.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ca.on.miro.event.consumer.model.User;

@Service
public class KafkaConsumer {
	
	/**
	 * Version 1: String message
	 *  Group conversations for different TOPICs
	 */
	@KafkaListener(topics = "TestTopic", groupId = "group_id")
	public void consumer(String message) {
		System.out.println("Consumed String message: "+message);
	}

	@KafkaListener (topics = "MiroTopicJson", groupId = "group_json", 
			containerFactory = "userKafkaListenerFactory")
	public void consumeJson(User user) {
		System.out.println("Consumed JSON message: "+user);
	}
}
