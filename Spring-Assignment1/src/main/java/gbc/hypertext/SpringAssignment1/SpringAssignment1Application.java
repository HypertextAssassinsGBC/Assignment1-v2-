package gbc.hypertext.SpringAssignment1;

import config.RegistrationService;
import config.WebSecurityConfig;
import model.User;
import model.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.UserRepository;

@Import({WebSecurityConfig.class})

@EntityScan("model")
@EnableJpaRepositories("repository")
@SpringBootApplication(scanBasePackages = "java**")
public class SpringAssignment1Application {
	private ApplicationContext applicationContext;

	public SpringAssignment1Application(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static final Logger log = LoggerFactory.getLogger(SpringAssignment1Application.class);



	@Bean
	public CommandLineRunner loadData(UserRepository userRepository) {
		return (args) -> {
			User admin = new User("Duncan", "Wardlaw", "duncan@gmail.com", "pass", UserRole.ADMIN);
			userRepository.save(admin);
			userRepository.save(new User("Jeff", "Bezos", "jeffybezos@gmail.com", "amazon", UserRole.USER));
			userRepository.save(new User("Mark", "Zuck", "markyzuck@gmail.com", "facebook", UserRole.USER));
			userRepository.save(new User("Eli", "Musky", "elongatedmusk@gmail.com", "tesla", UserRole.USER));


			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			log.info("");
		};
	}


	public static void main(String[] args) {


		SpringApplication.run(SpringAssignment1Application.class, args);
	}

}
