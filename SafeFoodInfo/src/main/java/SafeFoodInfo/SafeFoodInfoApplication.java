package SafeFoodInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SafeFoodInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafeFoodInfoApplication.class, args);
	}

}
