package fi.haagahelia.project.web;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import fi.haagahelia.project.domain.CategoryRepository;
import fi.haagahelia.project.domain.DietRepository;
import fi.haagahelia.project.domain.Recipe;
import fi.haagahelia.project.domain.RecipeRepository;

@Controller
public class RecipeController {
	@Autowired
	private RecipeRepository rrepository; 
	@Autowired
	private CategoryRepository crepository; 
	@Autowired 
	private DietRepository drepository;
	
	@RequestMapping("/Recipelist") // or ("/Recipelist")
	public String recipelist(Model model) {
		model.addAttribute("recipes", rrepository.findAll());
		return "Recipelist";
	}
	
	 // Add new recipe
    @RequestMapping(value = "/addrecipe")
    public String addRecipe(Model model){
    	model.addAttribute("recipe", new Recipe());
    	model.addAttribute("categories", crepository.findAll());
    	model.addAttribute("diets", drepository.findAll());
        return "AddRecipes";
    }  
    
    // Save new recipe
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Recipe recipe){
        rrepository.save(recipe);
        return "redirect:Recipelist";
    }   
    
    // Delete recipe
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRecipe(@PathVariable("id") Long recipeId, Model model) {
    	rrepository.delete(recipeId);
        return "redirect:../Recipelist";
    }     
	

	@RequestMapping(value="/Recipes", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> recipeListRest() {
	return(List<Recipe>) rrepository.findAll();


	
    }       
	
	// Save new Recipe 
	
//	@RequestMapping (method = Request.POST, value = BASE_PATH)
//	public String createFile(@RequestParam("file") MultipartFile file, RedirectAttribute) {
//		try {
//			imageService.createImage(file);
//			redirectAttribute.addFlashAttribute("flash.message", "Successfully uploaded " + file.getOriginalFilename());
//		} catch (IOException e) {
//			redirectAttribute.addFlashAttribute("flash.message", "Failed to upload " + file.getOriginalFilename());
			
//		}
//		return "redirect:/";
//	}
	
//@RequestMapping(method = Request.DELETE, value = BASE_PATH + "/" + FILENAME)
//@ResponseBody
//public ResponseEntity<?> deleteFile(@PathVariable String filename) {
	
//	try {
//		imageService.deleteImage(filename);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT)
//				.body("Sucessfully deleted " + filename);
//	} catch (IOException e) {
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//				.body("Failed to upload ") + file.getOriginalFilename() + "=> " + e.getMessage());
//	}
	
//}

//@RequestMapping(method =RequestMethod.DELETE, value = BASE_PATH + "/" + FILENAME)
//@ResponseEntity<?> deleteFile(@PathVariable String filename) {
//	
//	try {
//		imageService.deleteImage(filename);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT)
//				.body("Successfully deleted " + filename);
//	} catch (IOException e) {
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//				.body("Failed to delete " +filename + "=> " + e.getMessage());
//	}
	}
	
