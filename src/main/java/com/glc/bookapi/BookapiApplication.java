package com.glc.bookapi;




import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookapiApplication.class, args);
	}
	@RabbitListener(queues = "hello")
	public void receiver(String in) throws Exception {
		System.out.println(" [x] Received '" + in + "'");
	}

}
