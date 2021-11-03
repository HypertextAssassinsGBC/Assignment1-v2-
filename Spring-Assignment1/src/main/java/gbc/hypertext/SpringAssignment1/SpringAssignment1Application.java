package gbc.hypertext.SpringAssignment1;

import config.RegistrationService;
import config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Import({WebSecurityConfig.class})

@EntityScan("model")
@EnableJpaRepositories("repository")
@SpringBootApplication(scanBasePackages = "java**")
public class SpringAssignment1Application {
	private ApplicationContext applicationContext;

	public SpringAssignment1Application(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}


	public static void main(String[] args) {


		SpringApplication.run(SpringAssignment1Application.class, args);
	}

}
