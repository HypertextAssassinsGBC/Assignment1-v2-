package gbc.hypertext.SpringAssignment1;

import config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(WebSecurityConfig.class)
@SpringBootApplication
public class SpringAssignment1Application {



	public static void main(String[] args) {


		SpringApplication.run(SpringAssignment1Application.class, args);
	}

}
