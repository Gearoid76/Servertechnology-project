package fi.haagahelia.project.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface RecipeRepository extends CrudRepository <Recipe, Long> {
	
//List <Recipe>findByTitle(@Param("title")String title);

//List<Recipe>findByOrderByTitleAsc(@Param("title") String title);

List<Recipe> findBySamplepicture(String samplepicture);
}
