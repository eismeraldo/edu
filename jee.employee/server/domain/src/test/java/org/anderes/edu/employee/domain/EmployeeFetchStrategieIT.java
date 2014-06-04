package org.anderes.edu.employee.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.jboss.arquillian.persistence.CleanupStrategy.DEFAULT;
import static org.jboss.arquillian.persistence.TestExecutionPhase.BEFORE;
import static org.jboss.arquillian.persistence.TestExecutionPhase.NONE;
import static org.junit.Assert.assertThat;

import java.io.File;

import javax.inject.Inject;

import org.anderes.edu.employee.domain.Employee;
import org.anderes.edu.employee.domain.EmployeeRepository;
import org.anderes.edu.employee.domain.logger.LoggerProducer;
import org.anderes.edu.employee.persistence.EntityManagerProducer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupUsingScript;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@Cleanup(phase = NONE, strategy = DEFAULT)
public class EmployeeFetchStrategieIT {

    @Inject
    private EmployeeRepository repository;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
            .create(JavaArchive.class, "test.jar")
            // Domain-Klassen
            .addPackage(Employee.class.getPackage())
            // EntityManager-Producer
            .addClass(EntityManagerProducer.class)
            // Logger Producer
            .addClass(LoggerProducer.class)
            // Resourcen
            .addAsManifestResource(new File("target/test-classes/META-INF/derby-persistence.xml"), "persistence.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Test
    @InSequence(1)
    @CleanupUsingScript(value = "delete_all_rows.sql", phase = BEFORE)
    @UsingDataSet(value = { 
        "prepare-address.json", "prepare-employee.json", "prepare-degree.json",
        "prepare-email.json", "prepare-jobtitle.json", "prepare-emp_job.json",
        "prepare-project.json", "prepare-lproject.json", "prepare-phone.json",
        "prepare-proj_emp.json", "prepare-response.json", "prepare-salary.json"
        })
    public void fillDatabaseForSequence() {
        /* Test-Daten in die Datenbank abfüllen */
    }
 
    @Test
    @InSequence(2)
    public void shouldBeFindOneEmployeeAddress() {
        
        // when
        final Employee employee = repository.findOneEmployeeAddress(70L);
        
        // then
        assertThat(employee, is(notNullValue()));
        assertThat(employee.getFirstName(), is("John"));
        assertThat(employee.getLastName(), is("Way"));
        assertThat(employee.getJobTitle().getTitle(), is("Manager"));
        assertThat(employee.getAddress().getProvince(), is("ONT"));
    }
    
    @Test
    @InSequence(3)
    public void shouldBeFindOneEmployeeAddressJpql() {
        
        // when
        final Employee employee = repository.findOneEmployeeAddressJpql(70L);
        
        // then
        assertThat(employee, is(notNullValue()));
        assertThat(employee.getFirstName(), is("John"));
        assertThat(employee.getLastName(), is("Way"));
        assertThat(employee.getJobTitle().getTitle(), is("Manager"));
        assertThat(employee.getAddress().getProvince(), is("ONT"));
    }
    
    @Test
    @InSequence(4)
    /** ohne Transaktion klappt das mit dem Batch Fetching nicht (WebLogic 12.1.1, EclipseLink 2.3) */
    @Transactional(value = TransactionMode.DEFAULT) 
    public void shouldBeFindOneEmployeeAddressBatchFetching() {
        
        // when
        final Employee employee = repository.findOneEmployeeAddressQueryHint(70L);
        
        // then
        assertThat(employee, is(notNullValue()));
        assertThat(employee.getFirstName(), is("John"));
        assertThat(employee.getLastName(), is("Way"));
        assertThat(employee.getJobTitle().getTitle(), is("Manager"));
        assertThat(employee.getAddress().getProvince(), is("ONT"));
    }
}
