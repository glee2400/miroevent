package ca.on.miro.event.cloud.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Consumer need to use "Sink"
 *
 */
@SpringBootApplication
@EnableBinding(Sink.class)
public class MicroCloudstreamConsumerApplication {
	
	private Logger logger = LoggerFactory.getLogger(MicroCloudstreamConsumerApplication.class);
	
	@StreamListener("input")
	public void consumerMessage(Book book) {

		logger.info("Consume payload : "+book);
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroCloudstreamConsumerApplication.class, args);
	}

}
