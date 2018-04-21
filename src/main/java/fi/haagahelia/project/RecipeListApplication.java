package fi.haagahelia.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.project.domain.Category;
import fi.haagahelia.project.domain.CategoryRepository;
import fi.haagahelia.project.domain.Diet;
import fi.haagahelia.project.domain.DietRepository;
import fi.haagahelia.project.domain.Recipe;
import fi.haagahelia.project.domain.RecipeRepository;



@SpringBootApplication
public class RecipeListApplication {
	private static final Logger log = LoggerFactory.getLogger(RecipeListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RecipeListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recipeDemo(RecipeRepository rrepository, CategoryRepository crepository, DietRepository drepository) {
		return (args) -> {
			log.info("running of  crepository");
			crepository.save(new Category("Breakfast"));
			crepository.save(new Category("Salad"));
			crepository.save(new Category("Lunch"));
			crepository.save(new Category("Dinner"));
			crepository.save(new Category("Dessert"));
			crepository.save(new Category("Snacks"));
			crepository.save(new Category("Special Occasions"));
			
			log.info(" running of drepository");
			drepository.save(new Diet("Atkins"));
			drepository.save(new Diet("Ketogenic"));
			drepository.save(new Diet("Mediterranean"));
			drepository.save(new Diet("South Beach"));
			drepository.save(new Diet("Rawfood"));
			drepository.save(new Diet("Vegan"));
			drepository.save(new Diet("Vegetarian"));
			drepository.save(new Diet("Zone"));
			
			
			log.info(" running of rrepository");
			rrepository.save(new Recipe("Mushroom pie","picture of recipe", crepository.findByCname("Breakfast").get(0), drepository.findByDname("Atkins").get(0)));		
			rrepository.save(new Recipe("The adventures of Tom Sawyer","picture of recipe", crepository.findByCname("Breakfast").get(0), drepository.findByDname("Atkins").get(0)));
			rrepository.save(new Recipe("Chicken korma","picture of recipe", crepository.findByCname("Breakfast").get(0), drepository.findByDname("Atkins").get(0)));
			rrepository.save(new Recipe("BLT sandwich","picture of recipe", crepository.findByCname("Breakfast").get(0), drepository.findByDname("Atkins").get(0)));
			rrepository.save(new Recipe("Sheppards pie","picture of recipe", crepository.findByCname("Breakfast").get(0), drepository.findByDname("Atkins").get(0)));
			rrepository.save(new Recipe("cornflakes","picture of recipe", crepository.findByCname("Breakfast").get(0), drepository.findByDname("Atkins").get(0)));
		
	
			log.info("End of RecipeListApplication");
		};
	}
}
