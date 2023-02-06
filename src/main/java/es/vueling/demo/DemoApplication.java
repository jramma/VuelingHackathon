package es.vueling.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		try {
			Desktop.getDesktop().browse(new URI("http://localhost:9797/SearchInterface.html"));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		SpringApplication.run(DemoApplication.class, args);
	}

}
