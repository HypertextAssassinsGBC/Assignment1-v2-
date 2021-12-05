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
			User admin = new User("Duncan", "Wardlaw", "duncan@gmail.com", "pass");
			admin.setPassword(passwordEncoder.encode(admin.getPassword()));
			userRepository.save(admin);

			User jeff = new User("Jeff", "Bezos", "jeffybezos@gmail.com", "amazon");
			jeff.setPassword(passwordEncoder.encode(admin.getPassword()));
			userRepository.save(jeff);

			User mark = new User("Mark", "Zuck", "markyzuck@gmail.com", "facebook");
			mark.setPassword(passwordEncoder.encode(admin.getPassword()));
			userRepository.save(mark);

			User eli = new User("Eli", "Musky", "elongatedmusk@gmail.com", "tesla");
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

			List<String> lasagnaSteps = new ArrayList<>();
			lasagnaSteps.add("Put the lasagna together in a baking sheet.");
			lasagnaSteps.add("Then put in the oven for an hour.");
			lasagnaSteps.add("I don't fucking know.");

			Recipe lasagna = new Recipe(
					"Lasagna", lasagnaSteps ,
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

			List<String> soupSteps = new ArrayList<>();
			soupSteps.add("Cook the chicken. ");
			soupSteps.add("Put it in the soup.");
			Recipe chickenSoup = new Recipe(
					"Chicken Soup", soupSteps
					,
					soupIngredients
			);
			recipeRepository.save(chickenSoup);

			List<String> pumpkinCreamCheeseMuffins = new ArrayList<>();
			pumpkinCreamCheeseMuffins.add("1 (8 ounce) package cream cheese");
			pumpkinCreamCheeseMuffins.add("1 egg");
			pumpkinCreamCheeseMuffins.add("1 teaspoon vanilla extract");
			pumpkinCreamCheeseMuffins.add("3 tablespoons brown sugar");
			pumpkinCreamCheeseMuffins.add("5 tablespoons white sugar");

			List<String> pumpkinSteps = new ArrayList<>();
			pumpkinSteps.add("Put pumpkin and cream cheese near each other.");
			pumpkinSteps.add("Shape it into a muffin.");
			pumpkinSteps.add("Put muffin shaped thing in the oven.");
			Recipe pumpkinMuffins = new Recipe(
					"Pumpkin Cream Cheese Muffins",
					pumpkinSteps
					,
					pumpkinCreamCheeseMuffins
			);
			recipeRepository.save(pumpkinMuffins);

			List<String> EasyBrusselsSproutsSalad = new ArrayList<>();
			EasyBrusselsSproutsSalad.add("3 cups Brussels sprouts, halved");
			EasyBrusselsSproutsSalad.add("4 slices bacon");
			EasyBrusselsSproutsSalad.add("1 cup raisins");
			EasyBrusselsSproutsSalad.add("1 cup coleslaw dressing");

			List<String> saladSteps = new ArrayList<>();
			saladSteps.add("Cut all the things into salad sized pieces.");
			saladSteps.add("Shake the dressing a lot. Even more than you would think.");
			saladSteps.add("Combine everything in a large plastic salad spinner.");


			Recipe BrusselsSalad = new Recipe(
					"Easy Brussels Sprouts Salad",
					saladSteps,
					EasyBrusselsSproutsSalad
			);
			recipeRepository.save(BrusselsSalad);


		};
	}


	public static void main(String[] args) {


		SpringApplication.run(SpringAssignment1Application.class, args);
	}

}
