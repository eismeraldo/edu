/*
 * Copyright (c) 2012 VRSG | Verwaltungsrechenzentrum AG, St.Gallen
 * All Rights Reserved.
 */

package ch.vrsg.edu.jpa;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.text.StrBuilder;

@Entity
@NamedQueries(@NamedQuery(name = "Recipe.All", query = "Select r from Recipe r"))
public class Recipe {

    public final static String RECIPE_QUERY_ALL = "Recipe.All";

    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Timestamp lastUpdate;
    @Column(nullable = false, length = 200)
    private String title;
    @Embedded
    @Column(nullable = true)
    private Image image;
    @Temporal(TemporalType.DATE)
    private Date addingDate;
    private Integer rating;
    @ElementCollection
    @CollectionTable(name="TAGS", joinColumns=@JoinColumn(name="RECIPE_ID"))
    private Set<String> tags = new HashSet<String>();

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "RECIPE_ID")
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Recipe addTag(final String tag) {
        this.tags.add(tag);
        return this;
    }
    
    public void removeTag(final String tag) {
        this.tags.remove(tag);
    }
    
    @Override
    public String toString() {
        return new StrBuilder().append("Title: " + title).appendPadding(1, ' ')
                        .append("Rating: " + rating).appendPadding(1, ' ')
                        .append("AddingDate: " + addingDate).appendPadding(1, ' ')
                        .append(image).appendPadding(1, ' ')
                        .appendAll("Ingredients: " + ingredients).appendPadding(1, ' ')
                        .appendAll("Tags: " + tags)
                        .toString();
    }

    public void addIngredient(final Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(title).append(image).append(rating)
                        .append(addingDate).append(tags.toArray()).append(ingredients.toArray()).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Recipe rhs = (Recipe) obj;
        return new EqualsBuilder().append(title, rhs.title).append(image, rhs.image)
                        .append(rating, rhs.rating).append(tags.toArray(), rhs.tags.toArray())
                        .append(ingredients.toArray(), rhs.ingredients.toArray()).isEquals();
    }
}
