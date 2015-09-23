package org.anderes.edu.jee.rest.sample;

import static java.nio.charset.StandardCharsets.UTF_8;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.anderes.edu.jee.rest.sample.jaxbdto.Employee;
import static org.apache.commons.lang3.RandomStringUtils.*;

/**
 * REST-Service für Employee
 * <p>
 * Lösung mittels JAXB: Das Dto wird mittesl CSD und JAXB generiert.
 * 
 * @author René Anderes
 *
 */
@Path("/employees")
public class EmployeeResource {

	@GET
	@Produces({APPLICATION_XML, APPLICATION_JSON})
	public Response getAllEmployees() {
		final Collection<Employee> employees = createEmployeeCollection();
		
		final GenericEntity<Collection<Employee>> genericList = new GenericEntity<Collection<Employee>>(employees) {};
		return Response.ok(genericList).encoding(UTF_8.name()).build();
	}
	
	private Collection<Employee> createEmployeeCollection() {
	    final Collection<Employee> employees = new ArrayList<>();
        final int max = Integer.parseInt(randomNumeric(3));
        for (int i = 0; i < max; i++) {
            employees.add(createRndDummyEmployee());
        }
        return employees;
	}
	
	private Employee createRndDummyEmployee() {
		final Employee employee = new Employee();
		employee.setTitle("Herr");
		employee.setFirstname(randomAlphabetic(50));
		employee.setLastname(randomAlphabetic(50));
		final String persNo = String.format("%s-%s-%s", randomNumeric(2), randomNumeric(4), randomNumeric(1));
		employee.setPersonnelNo(persNo);
		return employee;
	}
}
