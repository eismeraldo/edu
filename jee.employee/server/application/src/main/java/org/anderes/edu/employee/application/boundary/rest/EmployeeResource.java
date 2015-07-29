package org.anderes.edu.employee.application.boundary.rest;

import static javax.ejb.TransactionAttributeType.NEVER;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.anderes.edu.employee.application.EmployeeFacade;
import org.anderes.edu.employee.application.boundary.DtoMapper;
import org.anderes.edu.employee.application.boundary.dto.EmployeeDto;
import org.anderes.edu.employee.application.boundary.dto.EmployeesDto;
import org.anderes.edu.employee.application.boundary.dto.Link;
import org.anderes.edu.employee.application.boundary.dto.ObjectFactory;
import org.anderes.edu.employee.application.boundary.dto.ProjectsDto;
import org.anderes.edu.employee.domain.Employee;

@Path("/employees")
@Stateless
@TransactionAttribute(NEVER)
@Produces({APPLICATION_JSON, APPLICATION_XML})
public class EmployeeResource {
	
	@EJB
	private EmployeeFacade facade;
	@Context
	private UriInfo uriInfo;
	@Inject
	private DtoMapper mapper;
	
	@GET
    @Path("/")
    public Response findEmployees(@QueryParam("salary") final Double salary) {
        if (salary == null || salary.equals(Double.valueOf(0D))) {
            return findEmployees();
        } 
        return findEmployeesBySalary(salary);
    }
	
    private Response findEmployees() {
	    final List<Employee> employees = facade.findEmployees();
	    final EmployeesDto dto = createLinksForEmployees(mapper.mapToEmployeesDto(employees));
        return Response.ok().entity(dto).build();
	}
	
    private Response findEmployeesBySalary(final Double salary) {
        final List<Employee> employees = facade.findEmployeeBySalary(salary);
        final EmployeesDto dto = createLinksForEmployees(mapper.mapToEmployeesDto(employees));
        return Response.ok().entity(dto).build();
    }
    
	@GET
	@Path("/{id: [0-9]+}")
	public Response findEmployee(@PathParam("id") final Long employeeId) {
	    final Optional<Employee> optional = facade.findOne(employeeId);
		if (!optional.isPresent()) {
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		final Employee employee = optional.get();
		final EmployeeDto dto = mapper.mapToEmployeeDto(employee);
		dto.getLink().addAll(createLinksForEmployee());
		return Response.ok().entity(dto).build();
	}
	
	@GET
	@Path("/{id: [0-9]+}/address")
	public Response findAddressForEmployee(@PathParam("id") final Long employeeId) {
	    final Optional<Employee> optional = facade.findOne(employeeId);
        if (!optional.isPresent()) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        final Employee employee = optional.get();
        if (!employee.getAddress().isPresent()) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return Response.ok().entity(mapper.mapToAddressDto(employee.getAddress().get())).build();
        
	}
	
	@GET
    @Path("/{id: [0-9]+}/projects")
    public Response findProjectsForEmployee(@PathParam("id") final Long employeeId) {
	    final Optional<Employee> optional = facade.findProjectsByEmployee(employeeId);
        if (!optional.isPresent()) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        final Employee employee = optional.get();
        final ProjectsDto projects = createLinksForProjects(mapper.mapToProjectsDto(employee.getProjects()));
        return Response.ok().entity(projects).build();
    }
	
	private String baseUrl() {
	    return uriInfo.getAbsolutePath().toString();
	}
	
	private Collection<Link> createLinksForEmployee() {
	    final ObjectFactory factory = new ObjectFactory();
        final ArrayList<Link> links = new ArrayList<>(2);
        final Link addressLink = factory.createLink();
        addressLink.setRel("address");
        addressLink.setUrl(baseUrl() + "/address");
        links.add(addressLink);
        final Link projectsLink = factory.createLink();
        projectsLink.setRel("projects");
        projectsLink.setUrl(baseUrl() + "/projects");
        links.add(projectsLink);
        return links;
    }
	
	private EmployeesDto createLinksForEmployees(final EmployeesDto employees) {
	    for (EmployeesDto.Employee employee : employees.getEmployee()) {
            employee.getLink().addAll(createLinksForEmployees(employee));
        }
	    return employees;
	}
	
	private Collection<Link> createLinksForEmployees(final EmployeesDto.Employee employee) {
	    final ObjectFactory factory = new ObjectFactory();
        final ArrayList<Link> links = new ArrayList<Link>(1);
        final Link link = factory.createLink();
        link.setRel("employee");
        link.setUrl(baseUrl() + "/" + employee.getId());
        links.add(link);
        return links;
    }
	
	private ProjectsDto createLinksForProjects(final ProjectsDto projects) {
	    for (ProjectsDto.Project project : projects.getProject()) {
	        project.getLink().addAll(createLinksForProject(project));
	    }
	    return projects;
	}
	
	private Collection<Link> createLinksForProject(final ProjectsDto.Project project) {
	    final ObjectFactory factory = new ObjectFactory();
	    final ArrayList<Link> links = new ArrayList<Link>(1);
        final Link link = factory.createLink();
        link.setRel("project");
        link.setUrl(uriInfo.getBaseUri().toString() + "/projects/" + project.getId());
        links.add(link);
        return links;
	}
}
