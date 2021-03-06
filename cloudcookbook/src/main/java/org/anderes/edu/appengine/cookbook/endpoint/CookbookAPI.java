package org.anderes.edu.appengine.cookbook.endpoint;

import java.util.List;

import javax.inject.Named;

import org.anderes.edu.appengine.cookbook.RecipeRepository;
import org.anderes.edu.appengine.cookbook.dto.Recipe;
import org.anderes.edu.appengine.cookbook.dto.RecipeShort;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.NotFoundException;

@Api(
    name = "cookbookApi",
    version = "v1",
    namespace = @ApiNamespace(
        ownerDomain = "cookbook.appengine.edu.anderes.org",
        ownerName = "anderes.org",
        packagePath = "cloud/platform")
)
public class CookbookAPI {

    private RecipeRepository repository = new RecipeRepository();
    
    @ApiMethod(
        name = "recipes.list",
        httpMethod = HttpMethod.GET
     )
    public List<RecipeShort> getRecipeCollection() {
        return repository.getRecipeCollection();
    }
    
    @ApiMethod(
        name = "recipes.findOne", 
        httpMethod = HttpMethod.GET
    )
    public Recipe getRecipe(@Named("id") String id) throws NotFoundException {
        try {
            return repository.findOne(id);
        } catch(com.googlecode.objectify.NotFoundException e) {
            throw new NotFoundException("Recipe not found with id: " + id);
        }
    }
    
    @ApiMethod(
        name = "recipes.save", 
        httpMethod = HttpMethod.POST
    )
    public Recipe saveRecipe(final Recipe recipe) {
        return repository.save(recipe);
    }
    
    @ApiMethod(
        name = "recipes.delete", 
        httpMethod = HttpMethod.DELETE
    )
    public void deleteRecipe(@Named("id") String id) throws NotFoundException {
        try {
            repository.delete(id);
        } catch(com.googlecode.objectify.NotFoundException e) {
            throw new NotFoundException("Recipe not found with id: " + id);
        }
    }
}
