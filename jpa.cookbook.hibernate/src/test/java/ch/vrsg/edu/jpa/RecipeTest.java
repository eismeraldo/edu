/*
 * Copyright (c) 2012 VRSG | Verwaltungsrechenzentrum AG, St.Gallen
 * All Rights Reserved.
 */

package ch.vrsg.edu.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class RecipeTest {

    private final Logger logger = LogManager.getLogger(this.getClass().getName());
    private static EntityManagerFactory emf;

    @BeforeClass
    public static void setupOnce() throws Exception {
        emf = Persistence.createEntityManagerFactory("Cookbook");
    }

    /**
     * Hinzufügen eines neuen Rezepts
     */
    @Test
    public void shouldBeAddNewAndCheck() {
        Recipe newData = RecipeTestData.DATA1.createRecipe();
        createEntity(newData);
        Object id = newData.getId();

        Recipe fromDb = readEntity(Recipe.class, id);
        assertThat(fromDb, is(notNullValue()));
        assertThat(fromDb, is(not(sameInstance(newData))));

        logger.info("\n--- " + readEntity(Recipe.class, id) + " ---\n");
    }

    /**
     * Hinzufügen von zwei Rezepten
     */
    @Test
    public void shouldBeAListOfRecipe() {
        createEntity(RecipeTestData.DATA1.createRecipe());
        createEntity(RecipeTestData.DATA2.createRecipe());
        checkRecipeWithNamedQuery();
        checkRecipeWithCriteriaAPI();
        checkIngredientWithCriteriaAPI();
    }

    /**
     * Überprüfen, ob es zweit Rezepte in der DB hat.<br>
     * Mittels "NamedQuery"
     */
    @SuppressWarnings("boxing")
    private void checkRecipeWithNamedQuery() {
        final EntityManager em = emf.createEntityManager();
        final TypedQuery<Recipe> tQuery = em.createNamedQuery(Recipe.RECIPE_QUERY_ALL, Recipe.class);
        
        assertThat(tQuery.getResultList().size(), is(2));
        for (Recipe r : tQuery.getResultList()) {
            logger.info("Rezept: " + r.toString());
            assertThat(r.getIngredients(), is(notNullValue()));
            assertThat(r.getIngredients().size(), is(2));
        }
    }

    /**
     * Überprüfen, ob es zweit Rezepte in der DB hat.<br>
     * Mittels "Criteria API"
     */
    @SuppressWarnings("boxing")
    private void checkRecipeWithCriteriaAPI() {
        final List<Recipe> list = selectAllRecipeWithCriteriaAPI();
        
        assertThat(list.size(), is(2));
        for (Recipe r : list) {
            logger.info(r.toString());
            assertThat(r.getIngredients(), is(notNullValue()));
            assertThat(r.getIngredients().size(), is(2));
        }
    }

    /**
     * Überprüfen, ob es vier Zutaten in der DB hat.<br>
     * Mittels "Criteria API"
     */
    @SuppressWarnings("boxing")
    private void checkIngredientWithCriteriaAPI() {
        final List<Ingredient> list = selectAllIngredientWithCriteria();
        assertThat(list.size(), is(4));
    }

    /**
     * Liefert eine Liste aller Rezepte zur�ck. Mittels <b>Criteria API</b><br>
     * Entspricht JPQL "Select r from Recipe r"
     * 
     * @return Liste aller Rezepte
     */
    private List<Recipe> selectAllRecipeWithCriteriaAPI() {
        final EntityManager em = emf.createEntityManager();

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Recipe> query = cb.createQuery(Recipe.class);
        final Root<Recipe> recipe = query.from(Recipe.class);
        query.select(recipe);
        final TypedQuery<Recipe> typedQuery = em.createQuery(query);
        final List<Recipe> recipes = typedQuery.getResultList();

        assertThat(recipes, is(notNullValue()));

        return recipes;
    }

    /**
     * Liefert eine Liste mit allen Zutaten zurück. Mittels. Mittels <b>Criteria API</b><br>
     * Entspricht JPQL "Select r from Ingredient r"
     * 
     * @return Liste mit allen Zutaten
     */
    private List<Ingredient> selectAllIngredientWithCriteria() {
        final EntityManager em = emf.createEntityManager();

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Ingredient> query = cb.createQuery(Ingredient.class);
        final Root<Ingredient> ingredient = query.from(Ingredient.class);
        query.select(ingredient);
        final TypedQuery<Ingredient> typedQuery = em.createQuery(query);
        final List<Ingredient> ingredients = typedQuery.getResultList();

        assertThat(ingredients, is(notNullValue()));

        return ingredients;
    }

    private <T> void createEntity(T entity) {
        final EntityManager em = emf.createEntityManager();
        final EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw ex;
        }
    }

    private <T> T readEntity(Class<T> clss, Object id) {
        EntityManager em = emf.createEntityManager();
        return em.find(clss, id);
    }

    private enum RecipeTestData {
        DATA1("Rezept für Pasta"), DATA2("Anderes Rezept für Pasta");

        private String title;

        private RecipeTestData(String title) {
            this.title = title;
        }
        public Recipe createRecipe() {
            Recipe newData = new Recipe();
            newData.setTitle(this.title);
            newData.setAddingDate(new Date());
            newData.setRating(4);
            newData.addTag("pasta").addTag("vegetarisch");
            newData.setImage(new Image("/images/test.jpg", "Bild für URL"));
            newData.addIngredient(new Ingredient("200g", "Pasta", "aus der Migros"));
            newData.addIngredient(new Ingredient("200g", "Pelati", "besser als frische Tomaten"));
            return newData;
        }
    }
}
