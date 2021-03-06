package org.anderes.edu.jpa.inheritance.mappedsuperclasses;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    private EntityManager entityManager;
    
    @Before
    public void setUp() throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("testDB");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown() throws Exception {
        entityManager.close();
    }

    @Test
    public void simpleTest() {
        addPersonToDatabase();
        
        final Collection<NaturalPerson> persons = getAllNaturalPersons();
        
        assertThat(persons, is(not(nullValue())));
        assertThat(persons.size(), is(1));
    }
    
    private Collection<NaturalPerson> getAllNaturalPersons() {
        final TypedQuery<NaturalPerson> query = entityManager.createQuery("Select e From NaturalPerson e", NaturalPerson.class);
        return query.getResultList();
    }

    private void addPersonToDatabase() {
        final Person person = new NaturalPerson("Mona-Lisa", "DaVinci");

        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }

}
