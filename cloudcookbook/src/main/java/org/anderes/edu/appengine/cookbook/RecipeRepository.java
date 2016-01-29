package org.anderes.edu.appengine.cookbook;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.lang3.Validate;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.NotFoundException;


public class RecipeRepository {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    
    /**
     * Findet ein einzelnes Rezept
     * 
     * @param id Datenbankidentität
     * @return Rezept
     * @throws NotFoundException falls die Entität mir der entsprechenden ID nicht existiert
     */
    public Recipe findOne(final String id) {
        Validate.notNull(id, "Parameter id darf nicht null sein");
        return ofy().load().type(Recipe.class).id(id).safe();
    }

    public Recipe save(final Recipe recipe) {
        Validate.notNull(recipe, "Parameter id darf nicht null sein");
        if (recipe.getId() == null) {
            recipe.setId(UUID.randomUUID().toString());
        }
        recipe.setEditingDate(new Date());
        if (recipe.getAddingDate() == null) {
            recipe.setAddingDate(new Date());
        }
        final Key<Recipe> key = ofy().save().entity(recipe).now();
        logger.info("Rezept mit Key '" + key.toWebSafeString() + "' gespeichert.");
        return recipe;
    }
    
    public void delete(final Recipe recipe) {
        Validate.notNull(recipe, "Parameter id darf nicht null sein");
        ofy().delete().entity(recipe).now();
    }

    public Collection<Recipe> findByTitle(final String title) {
        return ofy().load().type(Recipe.class).filter("title >=", title).filter("title <", title + "\ufffd").list();
    }

    public List<Recipe> findAll() {
        return ofy().load().type(Recipe.class).list();
    }
}
