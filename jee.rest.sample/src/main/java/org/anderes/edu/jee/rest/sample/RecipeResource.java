package org.anderes.edu.jee.rest.sample;

import static java.nio.charset.StandardCharsets.UTF_8;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST-service für Rezepte, Lösunge mittels JSON-P
 * 
 * @author René Anderes
 *
 */
@Path("/recipes")
public class RecipeResource {

    
    @GET
    @Produces({APPLICATION_JSON})
    public Response getRecipeCollection() {
        
        JsonObject recipe_1 = Json.createObjectBuilder().add("title", "Tiramisu").add("id", "2006").build();
        JsonObject recipe_2 = Json.createObjectBuilder().add("title", "Spagetti").add("id", "2010").build();
        
        JsonArray recipes = Json.createArrayBuilder().add(recipe_1).add(recipe_2).build();
        
        return Response.ok(recipes).encoding(UTF_8.name()).build();
    }
    
    @GET
    @Path("{recipeId: [0-9]+}")
    @Produces({APPLICATION_JSON})
    public Response getRecipe(@PathParam("recipeId") Integer id) {
        
        JsonObject recipe = Json.createObjectBuilder()
                        .add("id", "2006")
                        .add("title", "Tiramisu")
                        .add("preamble", "Es gibt viele verschiedene ...")
                        .add("numberOfPerson", 4)
                        .build();
        
        return Response.ok().entity(recipe).encoding(UTF_8.name()).build();
    }
}
