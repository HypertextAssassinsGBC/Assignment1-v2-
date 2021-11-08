package gbc.hypertext.SpringAssignment1;

import gbc.hypertext.SpringAssignment1.config.WebSecurityConfig;
import gbc.hypertext.SpringAssignment1.model.Cookbook;
import gbc.hypertext.SpringAssignment1.model.Recipe;
import gbc.hypertext.SpringAssignment1.model.User;

import gbc.hypertext.SpringAssignment1.repository.CookBookRepository;
import gbc.hypertext.SpringAssignment1.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import gbc.hypertext.SpringAssignment1.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Import({WebSecurityConfig.class})
@EntityScan("gbc/hypertext/SpringAssignment1/model")
@EnableJpaRepositories("gbc.hypertext.SpringAssignment1.repository")
@SpringBootApplication()
public class SpringAssignment1Application {
	private ApplicationContext applicationContext;
	@Autowired
	PasswordEncoder passwordEncoder;


	public SpringAssignment1Application(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static final Logger log = LoggerFactory.getLogger(SpringAssignment1Application.class);



	@Bean
	public CommandLineRunner loadData(UserRepository userRepository, CookBookRepository cookBookRepository, RecipeRepository recipeRepository) {
		return (args) -> {

			//Bootstrap users
			User admin = new User("Duncan", "Wardlaw", "duncan@gmail.com", "pass", "USER");
			admin.setPassword(passwordEncoder.encode(admin.getPassword()));
			userRepository.save(admin);

			User jeff = new User("Jeff", "Bezos", "jeffybezos@gmail.com", "amazon", "USER");
			jeff.setPassword(passwordEncoder.encode(admin.getPassword()));
			userRepository.save(jeff);

			User mark = new User("Mark", "Zuck", "markyzuck@gmail.com", "facebook", "USER");
			mark.setPassword(passwordEncoder.encode(admin.getPassword()));
			userRepository.save(mark);

			User eli = new User("Eli", "Musky", "elongatedmusk@gmail.com", "tesla", "USER");
			eli.setPassword(passwordEncoder.encode(admin.getPassword()));
			userRepository.save(eli);



			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			//Bootstrap Recipes
			//Lasagna
			List<String> lasagnaIngredients = new ArrayList<>();
			lasagnaIngredients.add("Cheese");
			lasagnaIngredients.add("Pasta");
			lasagnaIngredients.add("Tomato sauce");
			lasagnaIngredients.add("Beef");

			Recipe lasagna = new Recipe(
					"Lasagna",
					"Put the lasagna together in a baking sheet. Then put in the oven for an hour. I don't fucking know.",
					lasagnaIngredients
			);
			recipeRepository.save(lasagna);
			//Chicken soup
			List<String> soupIngredients = new ArrayList<>();
			soupIngredients.add("Chicken");
			soupIngredients.add("Broth");
			soupIngredients.add("Onions");
			soupIngredients.add("Carrots");
			soupIngredients.add("Celery");
			Recipe chickenSoup = new Recipe(
					"Chicken Soup",
					"Cook the chicken. Put it in the soup.",
					soupIngredients
			);
			recipeRepository.save(chickenSoup);

			//Bootstrap Cookbooks
			Cookbook markBook = new Cookbook("Mark's Cookbook");
			markBook.addRecipe(chickenSoup);
			markBook.addRecipe(lasagna);
			cookBookRepository.save(markBook);
		};
	}


	public static void main(String[] args) {


		SpringApplication.run(SpringAssignment1Application.class, args);
	}

}
