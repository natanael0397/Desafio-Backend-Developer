package challengebackenddeveloper.challengebackenddeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BackendDeveloperSvmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendDeveloperSvmApplication.class, args);
	}

}
