package ca.on.miro.event.cloud.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Publisher need to be "Source"
 * 
 * The Source must be "org.springframework.cloud.stream.messaging.Source"
 *
 */
@SpringBootApplication
@EnableBinding(Source.class)
@RestController
public class MicroCloudstreamProducerApplication {
	
	@Autowired
	private MessageChannel output;

	@PostMapping("/publish")
	public Book publishEvent(@RequestBody Book book){
		
		output.send(MessageBuilder.withPayload(book).build());
		return book;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(MicroCloudstreamProducerApplication.class, args);
	}

}
