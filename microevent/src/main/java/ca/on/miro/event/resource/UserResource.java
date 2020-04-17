package ca.on.miro.event.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.on.miro.event.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {

	/* 
	 * Version 1: Sending String message
	 */
    //@Autowired
    //private KafkaTemplate<String, String> kafkaTemplate;

	/* 
	 * Version 2: Sending JSON message
	 */
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    
    private static final String TOPIC = "TestTopic";
    
    
    @GetMapping("/")
    public String Home() {
    	System.out.print("---Here --");
    	return "Here";
    }
    
    /*
     * Version 1: Sending String type messgae
     *
    @GetMapping("/publish/{message}")
    public String post(@PathVariable("message") final String message) {

        kafkaTemplate.send(TOPIC, message);

        return "Published successfully";
    }
    */
    
    /*
     * Version 2: Sending JSON message
     */
    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));

        return "Published successfully";
    }
    
}